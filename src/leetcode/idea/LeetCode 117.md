# LeetCode 117

题目（[题目思路来源](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/)）

![image-20200928200714338](https://raw.githubusercontent.com/LYZhi/Images/master/img/20200928203044.png)

![image-20200928200736094](https://raw.githubusercontent.com/LYZhi/Images/master/img/20200928203057.png)

### 题解一

由题目我们可以看出来，此题实际是想让我们进行层次遍历

层次遍历的思路

- 创建一个队列，将节点放入队列中
- 随着取出一个节点时，将此节点的子节点再次放入队列中
- 直到队列为空时结束

此题思路

- 举例：首先放入头节点，记录此层节点数为1，然后取出头节点，同时向队列中放入此节点的左右子节点
- 整体思路
  - 记录每层的节点数，进行循环——取出此层的节点，放入与之对应的下一层的节点
  - 循环判断队列是否为空

```JAVA
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            Node pre = null;
            for(int i = 0;i < level;i++){
                Node node = queue.poll();
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
```

### 题解二

由于我们一遍遍的将数据存入并且取出，耗费时间，所以我们可以抛弃队列

此题实质就是将每一层串成链。那么我们可以在遍历i层时，将i+1层串起来

- 我们需要设置起始节点，每层从起始节点开始遍历该层
- 设置下一节点的坐标节点两个
  - 一个用来对i+1层进行串联
  - 一个用来使得i层遍历结束后，成功移到i+1层

```JAVA
public Node connect(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

```

