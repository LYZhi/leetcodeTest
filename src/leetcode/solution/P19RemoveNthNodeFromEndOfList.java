//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1039 👎 0

package leetcode.solution;


import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

//java:删除链表的倒数第N个节点
class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args){
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        String nums = "1,2,3,4,5";
        ListHelper listHelper = new ListHelper();
        ListNode head = listHelper.creatList(nums);
        listHelper.printList(solution.removeNthFromEnd(head,2));
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0,head);
        //快慢指针
        ListNode first  = head;
        ListNode second = temp;
        //找到领先节点数
        for(int i = 0;i<n;i++){
            first = first.next;
        }
        //当first到结尾时，second正好是n的前驱节点
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = temp.next;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
