//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
//给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
//给定的树 B：
//
// 4
// /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树
// 👍 172 👎 0


package leetcode.solution.leetcode;

import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

public class POffer_26_ShuDeZiJieGouLcof {
//树的子结构

    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_26_ShuDeZiJieGouLcof().new Solution();
        String s1 = "3,4,5,1,2";
        String s2 = "4,1";
        TreeHelper helper1 = new TreeHelper();
        TreeHelper helper2 = new TreeHelper();
        helper1.setValues(s1);
        TreeNode A = helper1.bulidBST();
        helper2.setValues(s2);
        TreeNode B = helper2.bulidBST();

        System.out.println(solution.isSubStructure(A, B));


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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (preOrder(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }


        private boolean preOrder(TreeNode A, TreeNode B) {
            if(B == null) {
                return true;
            }
            if(A == null || A.val != B.val) {
                return false;
            }
            return preOrder(A.left, B.left) && preOrder(A.right, B.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}