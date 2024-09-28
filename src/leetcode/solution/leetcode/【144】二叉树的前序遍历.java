//给定一个二叉树，返回它的 前序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 433 👎 0
package leetcode.solution.leetcode;

import leetcode.solution.config.TreeNode;

import java.util.ArrayList;
import java.util.List;

//java:二叉树的前序遍历
class P144BinaryTreePreorderTraversal{
    public static void main(String[] args){
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        String s = "1,null,2,3";
        leetcode.solution.config.TreeHelper treeHelper = new leetcode.solution.config.TreeHelper();
        treeHelper.setValues(s);
        System.out.println(solution.preorderTraversal(treeHelper.createTree()));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }

    private void preorder (TreeNode node,List<Integer> ans){
        if (node == null){
            return ;
        }
        ans.add(node.val);
        preorder(node.left,ans);
        preorder(node.right,ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
