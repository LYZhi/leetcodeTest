//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
// Related Topics 链表 双指针
// 👍 124 👎 0

package leetcode.solution.leetcode;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

//链表中倒数第k个节点
public class POffer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        String s = "1,2,3,4,5";
        ListHelper listHelper = new ListHelper();
        listHelper.printList(solution.getKthFromEnd(listHelper.creatList(s),3));
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
        /**
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode fast = head;
            ListNode last = head;
            for (int i = 1; i < k; i++) {
                fast = fast.next;
            }

            while (fast.next != null){
                fast = fast.next;
                last = last.next;
            }
            return last;
        }

         */
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode fast = head;
            ListNode last = head;
            int t = 1;
            while (fast.next != null){
                if (t>=k){
                    last = last.next;
                }
                fast = fast.next;
                t++;
            }
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}