//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 244 👎 0

package leetcode.solution.leetcode;


import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

import java.util.HashMap;
import java.util.Map;

//java:重建二叉树
class POffer_07ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new POffer_07ZhongJianErChaShuLcof().new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode ans = solution.buildTree(preorder,inorder);
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.preOrder(ans);

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || preorder == null) {
                return null;
            }
            int len = inorder.length;
            //将中继存入map中
            Map<Integer, Integer> temp = new HashMap<>();
            for (int i = 0; i < len; i++) {
                temp.put(inorder[i], i);
            }
            TreeNode ans = ans(preorder, 0, len - 1,
                    inorder, 0, len - 1, temp);
            return ans;

        }

        private TreeNode ans(int[] preorder, int preorderStart, int preorderEnd,
                             int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> temp) {

            if (preorderStart > preorderEnd) {
                return null;
            }
            int rootVal = preorder[preorderStart];
            int rootNum = temp.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            if (preorderStart == preorderEnd) {
                return root;
            }else {
                //找到左右子节点个数
                int left = rootNum - inorderStart;
                int right = inorderEnd - rootNum;
                //找左右节点
                TreeNode leftRoot = ans(preorder, preorderStart + 1, preorderStart + left,
                        inorder, inorderStart, rootNum - 1, temp);
                TreeNode rightRoot = ans(preorder, preorderEnd - right + 1, preorderEnd,
                        inorder, rootNum + 1, inorderEnd, temp);
                root.left = leftRoot;
                root.right = rightRoot;
                return root;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
