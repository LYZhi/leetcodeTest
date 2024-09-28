package leetcode.solution.leetcode;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
//1 3 6 9
//镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
//9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树
// 👍 92 👎 0

//二叉树的镜像

import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

public class POffer_27_ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_27_ErChaShuDeJingXiangLcof().new Solution();
        String s = "4,2,7,1,3,6,9";
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.setValues(s);
        TreeNode treeNode =treeHelper.bulidBST();
        treeHelper.preOrder(solution.mirrorTree(treeNode));


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
        public TreeNode mirrorTree(TreeNode root) {

            if (root == null || root.left == null && root.right == null) {
                return root;
            }
            mirrorTree(root.left);
            mirrorTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}