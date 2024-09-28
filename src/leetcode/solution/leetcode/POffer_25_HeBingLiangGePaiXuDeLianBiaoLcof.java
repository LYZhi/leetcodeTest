//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 分治算法
// 👍 77 👎 0


//合并两个排序的链表
package leetcode.solution.leetcode;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

public class POffer_25_HeBingLiangGePaiXuDeLianBiaoLcof {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_25_HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        String s1 = "1,2,4";
        String s2 = "1,3,4";

        ListHelper listHelper = new ListHelper();

        ListNode l1 = listHelper.creatList(s1);
        ListNode l2 = listHelper.creatList(s2);

        listHelper.printList(solution.mergeTwoLists(l1,l2));

    }
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newlist = new ListNode();
            ListNode header = newlist;
            while (l1!= null && l2 != null) {
                if (l1.val >= l2.val) {
                    newlist.next = l2;
                    l2 = l2.next;
                } else {
                    newlist.next = l1;
                    l1 = l1.next;
                }
                newlist = newlist.next;


            }
            if (l1== null) {
                newlist.next = l2;
            } else {
                newlist.next = l1;
            }
            return header.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}