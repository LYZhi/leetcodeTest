package leetcode.solution.config;

/**
 * @author LYZhi
 * @date 2020/9/23 19:10
 */
public class TreeHelper {

    static int index;
    static String[] values;

    public TreeHelper() {
    }

    // 根据形如”1，2，#，4，5，#，7，#“的字符串建立二叉树，其中#代表该节点为空
    public void setValues(String treeValues) {
        values = treeValues.split(",");
        index = 0;

    }

    //创建二叉搜索树
    public TreeNode bulidBST() {
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        for (int i = 1; i < values.length; i++) {
            createBST(root, Integer.parseInt(values[i]));
        }
        return root;
    }

    public void createBST(TreeNode node, int val) {
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        for (int i = 1; i < values.length; i++) {
            if (values[i] == null){

            }
            createBST(root, Integer.parseInt(values[i]));
        }
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                createBST(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                createBST(node.right, val);
            }
        }
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
