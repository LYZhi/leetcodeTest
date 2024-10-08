package leetcode.solution.leetcode;

import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 👍 121 👎 0
//对称的二叉树
public class POffer_28_DuiChengDeErChaShuLcof {


    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_28_DuiChengDeErChaShuLcof().new Solution();
        String s = "1,2,2,3,4,4,3";
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.setValues(s);
        TreeNode treeNode = treeHelper.bulidBST();
        System.out.println(solution.isSymmetric(treeNode));
    }
//力扣代码
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
        public boolean isSymmetric(TreeNode root) {
            return root == null ? true : ans(root.left, root.right);

        }
        private boolean ans(TreeNode L, TreeNode R) {
            if (L == null && R == null) {
                return true;
            }
            if (L == null || R == null || L.val != R.val) {
                return false;
            }
            return ans(L.left, R.right) && ans(L.right, R.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
