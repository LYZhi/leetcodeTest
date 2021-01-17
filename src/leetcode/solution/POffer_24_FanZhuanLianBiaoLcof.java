package leetcode.solution;
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 160 👎 0


//反转链表

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

public class POffer_24_FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_24_FanZhuanLianBiaoLcof().new Solution();
        String s = "1,2,3,4,5";
        ListHelper listHelper = new ListHelper();
        listHelper.printList(solution.reverseList(listHelper.creatList(s)));
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
        public ListNode reverseList(ListNode head) {
            ListNode now = head;
            ListNode cur = null;

            while (now != null) {
                ListNode temp = now.next;
                now.next = cur;
                cur = now;
                now = temp;
            }
            return cur;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}