package leetcode.solution.leetcode;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

/**
 * @author LYZhi
 * @date 2021/1/28 下午9:20
 */
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1503 👎 0


//合并两个有序链表

public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
        String s = "1,2,2,3,4,5";
        String s1 = "1,4,6,7,8";
        ListHelper listHelper = new ListHelper();
        listHelper.printList(solution.mergeTwoLists(listHelper.creatList(s),listHelper.creatList(s1)));
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /*
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode ans = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val){
                    head.next = l1;
                    l1 = l1.next;
                }else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }
            if (l1 == null){
                head.next = l2;
            }else {
                head.next = l1;
            }
            return ans.next;
        }
    }

     */

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
