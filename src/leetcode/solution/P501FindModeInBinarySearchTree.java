//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 163 👎 0

package leetcode.solution;

import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//java:二叉搜索树中的众数
class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();

        TreeHelper treeHelper = new TreeHelper();
        treeHelper.setValues("1,null,2,2");
        int[] ans = new int[10000];
        ans = solution.findMode(treeHelper.createTree());
        System.out.println(Arrays.toString(ans));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int maxTimes = 0;
        int thisTimes = 0;
        List<Integer> res = new LinkedList<Integer>();
        TreeNode temp = null;

        public int[] findMode(TreeNode root) {
            inOrder(root);
            int length = res.size();
            int[] rr = new int[length];
            for (int i = 0; i < length; i++) {
                rr[i] = res.get(i);
            }
            return rr;
        }

        public void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);

            if (temp != null && temp.val == root.val) {
                thisTimes++;
            } else {
                thisTimes = 1;
            }

            if (thisTimes == maxTimes) {
                res.add(root.val);
            } else if (thisTimes > maxTimes) {
                maxTimes = thisTimes;
                res.clear();
                res.add(root.val);
            }
            temp = root;
            inOrder(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
