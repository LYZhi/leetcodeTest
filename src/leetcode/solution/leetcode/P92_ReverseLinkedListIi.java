package leetcode.solution.leetcode;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

/**
 * @author LYZhi
 * @date 2021/1/28 上午11:37
 */
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 651 👎 0

//反转链表 II

public class P92_ReverseLinkedListIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
        String s = "1,2,3,4,5";
        ListHelper listHelper = new ListHelper();
        listHelper.printList(solution.reverseBetween(listHelper.creatList(s),2,4));
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
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode pre = null;
            int num =  n-m+1;
            ListNode ans = head;
            while (head != null&&m != 1){
                --m;
                pre = head;
                head = head.next;
            }
            ListNode fast = head;
            ListNode low = null;
            while(head != null&& num != 0){
                num--;
                ListNode temp = head.next;
                head.next = low;
                low = head;
                head = temp;
            }
            fast.next = head;
            if (pre != null){
                pre.next = low;
            }else{
                ans = low;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}