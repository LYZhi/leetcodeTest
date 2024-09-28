//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5019 👎 0

package leetcode.solution.leetcode;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

import java.util.Scanner;

//java:两数相加
class P2AddTwoNumbers {
    public static void main(String[] args){
        Solution solution = new P2AddTwoNumbers().new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字的倒叙,例【2,3,4】");
        String S1 = scanner.next();
        System.out.println("请输入第二个数字的倒叙");
        String S2 = scanner.next();
        ListHelper l1 = new ListHelper();
        ListHelper l2 = new ListHelper();

        ListNode ans = solution.addTwoNumbers(l1.creatList(S1),l2.creatList(S2));
        l1.printList(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null?0:l1.val;
            int y = l2 == null?0:l2.val;

            int sum  = x + y +carry;
            carry = sum /10;
            sum = sum %10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            if(carry == 1){
                cur.next = new ListNode(carry);
            }
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
