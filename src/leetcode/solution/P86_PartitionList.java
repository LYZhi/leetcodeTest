package leetcode.solution;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

/**
 * @author LYZhi
 * @date 2021/1/28 下午4:46
 */
//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
//
//
// 示例：
//
//
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
//
// Related Topics 链表 双指针
// 👍 355 👎 0


//分隔链表

public class P86_PartitionList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P86_PartitionList().new Solution();
        String s = "3,1,1,3,0,4,2,2,3,1,2";
        ListHelper listHelper = new ListHelper();
        listHelper.printList(solution.partition(listHelper.creatList(s), 4));
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
        public ListNode partition(ListNode head, int x) {

            if (head == null || head.next == null){
                return head;
            }
            ListNode ans = head;
            ListNode min = head;
            while (true) {
                if (head == null|| head.next == null) {
                    break;
                }
                ListNode pre = head;
                head = head.next;

                if (head.val < x) {

                    if (pre.val < x) {
                        min = head;
//                        head = head.next;
                        continue;
                    }
                    //后续连接
                    pre.next = head.next;
                    if (min.val >= x) {
                        head.next = min;
                        ans = head;
                    } else {
                        ListNode temp = min.next;
                        min.next = head;
                        head.next = temp;
                    }
                    min = head;
                }
            }
            return ans;
        }
    }
    */

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}