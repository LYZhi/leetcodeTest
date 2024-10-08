//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针 
// 👍 668 👎 0

package leetcode.solution.leetcode;


import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

//java:环形链表 II
class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        ListHelper listHelper = new ListHelper();
        ListNode head = listHelper.creatList("1,2,3,4,2");
        System.out.println(solution.detectCycle(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /*
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> ans = new HashSet<>();
            while(head != null){
                if(!ans.add(head)){
                    return head;
                }
                head = head.next;
            }
            return head;
        }
        */


        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            fast = head;
            //指针第二次相遇
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
