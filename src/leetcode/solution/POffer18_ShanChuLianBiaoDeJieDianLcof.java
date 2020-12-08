package leetcode.solution;

import leetcode.solution.config.ListHelper;
import leetcode.solution.config.ListNode;

public class POffer18_ShanChuLianBiaoDeJieDianLcof {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer18_ShanChuLianBiaoDeJieDianLcof().new Solution();
        ListHelper listHelper = new ListHelper();
        String s = "4,5,2,9";
        ListNode head = listHelper.creatList(s);
        listHelper.printList(solution.deleteNode(head,4));
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
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val ){
                return head.next;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            while(cur != null && cur.val != val){
                pre = cur;
                cur = cur.next;
            }
            if(cur != null){
                pre.next = cur.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
