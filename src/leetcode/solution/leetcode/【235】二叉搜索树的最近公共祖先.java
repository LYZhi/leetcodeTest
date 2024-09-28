package leetcode.solution.leetcode;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//
//
// 示例 2:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。
//
// Related Topics 树
// 👍 440 👎 0

import leetcode.solution.config.TreeHelper;
import leetcode.solution.config.TreeNode;

//java:二叉搜索树的最近公共祖先
class P235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();

        TreeHelper treeHelper = new TreeHelper();
        //此处构建的并不是二叉搜索树，我偷懒了
        treeHelper.setValues("1,null,2");
        TreeNode treeNode = solution.lowestCommonAncestor(treeHelper.createTree(),
                new TreeNode(2), new TreeNode(2));
        System.out.println(treeNode.val);
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

    /*class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> list1 = ans(root, p);
            List<TreeNode> list2 = ans(root, q);

            TreeNode node = null;
            //遍历节点路径，找到共同的祖先节点
            for (int i = 0; i < list1.size() && i < list2.size(); ++i) {
                if (list1.get(i) == list2.get(i)) {
                    node =  list1.get(i);
                }else{
                    break;
                }
            }
            return node;
        }


        public List<TreeNode> ans(TreeNode root, TreeNode temp) {
            TreeNode node =root;
            //构建一个list进行记录节点路径
            List<TreeNode> list = new ArrayList<TreeNode>();
            while (node.val != temp.val) {
                list.add(node);
                if (node.val < temp.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            list.add(node);
            return list;
        }
    }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ans = root;
            while (true) {
                if (p.val < ans.val && q.val < ans.val) {
                    ans = ans.left;
                } else if (p.val > ans.val && q.val > ans.val) {
                    ans = ans.right;
                } else {
                    break;
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}


