package leetcode.solution.config;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LYZhi
 * @date 2020/9/23 19:10
 */
public class TreeHelper {

    static int index;
    static String[] values;
    static int[] tree;

    public TreeHelper() {
    }

    // 根据形如”1，2，#，4，5，#，7，#“的字符串建立二叉树，其中#代表该节点为空
    public void setValues(String treeValues) {
        values = treeValues.split(",");
        index = 0;
        tree = new int[values.length];
        for (int i = 0;i<values.length;i++){
            tree[i] = Integer.parseInt(values[i]);
        }

    }

    //创建二叉搜索树
    public TreeNode bulidBST() {
        TreeNode p = new TreeNode(tree[0]);
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 0;
        while (p != null) {
            if (2 * i + 1 < tree.length) {
                p.left = new TreeNode(tree[2 * i + 1]);
                queue.add(p.left);
            }
            if (2 * i + 2 < tree.length) {
                p.right = new TreeNode(tree[2 * i + 2]);
                queue.add(p.right);
            }
            p = queue.poll();
            i += 1;
        }
        return q;
    }


    // 递归建立二叉树
    public TreeNode createTree() {
        TreeNode node = null;
        if (index < values.length) {
            if (values[index].equals("null")) {
                index++;
                return null;
            }
            node = new TreeNode(Integer.parseInt(values[index]));
            index++;
            node.left = createTree();
            node.right = createTree();
        }
        return node;
    }

    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            System.out.print(root.val + " ");
            preOrder(root.right);
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
}
