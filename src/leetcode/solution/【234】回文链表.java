//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 739 👎 0

package leetcode.solution;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

//java:回文链表
class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        String s = "-130,-130";
        ListHelper listHelper = new ListHelper();
        System.out.println(solution.isPalindrome(listHelper.creatList(s)));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
//    class Solution {
//        public boolean isPalindrome(ListNode head) {
//
//            ArrayList ans = new ArrayList();
//            ListNode temp = head;
//            while (temp != null) {
//                ans.add(temp.val);
//                temp = temp.next;
//            }
//            int len = ans.size();
//            int i = 0;
//            int j = len - 1;
//            for (; i <= j; i++, j--) {
//                if (ans.get(i).equals(ans.get(j))) {
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

//    class Solution {
//        public boolean isPalindrome(ListNode head) {
//            if (head == null) {
//                return true;
//            }
//
//            // 找到前半部分链表的尾节点并反转后半部分链表
//            ListNode firstHalfEnd = endOfFirstHalf(head);
//            ListNode secondHalfStart = reverseList(firstHalfEnd.next);
//
//            // 判断是否回文
//            ListNode p1 = head;
//            ListNode p2 = secondHalfStart;
//            boolean result = true;
//            while (result && p2 != null) {
//                if (p1.val != p2.val) {
//                    result = false;
//                }
//                p1 = p1.next;
//                p2 = p2.next;
//            }
//
//            // 再次翻转链表实现还原链表并返回结果
//            firstHalfEnd.next = reverseList(secondHalfStart);
//            return result;
//        }
//
//        //翻转链表
//        private ListNode reverseList(ListNode head) {
//            ListNode prev = null;
//            ListNode curr = head;
//            while (curr != null) {
//                ListNode nextTemp = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = nextTemp;
//            }
//            return prev;
//        }
//
//        private ListNode endOfFirstHalf(ListNode head) {
//            //快慢指针找到需要翻转处节点
//            ListNode fast = head;
//            ListNode slow = head;
//            while (fast.next != null && fast.next.next != null) {
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            return slow;
//        }
//    }

        //hash
    class Solution {
        public boolean isPalindrome(ListNode head) {
            long hash1 = 0, hash2 = 0, h = 1;
            long seed = (long) (1e9 + 7);
            ListNode p = head;
            while (p != null) {
                hash1 = hash1 * seed + p.val;
                hash2 = hash2 + h * p.val;
                h *= seed;
                p = p.next;
            }
            return hash1 == hash2;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
