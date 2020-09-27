# LeetCode 235

题目

![image-20200927205422972](https://raw.githubusercontent.com/LYZhi/Images/master/img/20200927211646.png)

![image-20200927205444770](https://raw.githubusercontent.com/LYZhi/Images/master/img/20200927211659.png)



### 题解一

如果想要找到指定节点的最近公共祖先节点，那么只需要将找到指定节点时经过的路径记录下来，那么就可以通过对两个的路径进行对比来确定最近公共祖先节点

- 记录节点经过的路径

  - 由于题目给的是二叉搜索树，且指定节点一定位于树中，所以不需要进行判空

  ```java
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
          
          
  ```

  - 只需要在遍历树时进行记录每次经过的节点就可以了

    ``` java
    		TreeNode node = null;
                //遍历节点路径，找到共同的祖先节点
                for (int i = 0; i < list1.size() && i < list2.size(); ++i) {
                    if (list1.get(i) == list2.get(i)) {
                        node =  list1.get(i);
                    }else{
                        break;
                    }
                }
    ```

    

### 题解二

由于二叉搜索树的特殊性，我们可以知道p,q与遍历时的当前节点存在三种状态：

1. pq均大于当前节点，那么pq的公共祖先节点在当前节点右子树上
2. pq均小于当前节点，那么pq的公共祖先节点在当前节点左子树上
3. pq一个大于当前节点，一个小于当前节点，则当前节点就是pq的公共祖先节点，从此节点往后，pq会存在于左右两棵子树上，不在拥有公共节点

所以，当`ans.val < p.val && ans.val > q.val || ans.val > p.val && ans.val < q.val`时，答案出现了

```java
while (true) {
                if (p.val < ans.val && q.val < ans.val) {
                    ans = ans.left;
                } else if (p.val > ans.val && q.val > ans.val) {
                    ans = ans.right;
                } else {
                    break;
                }
            }
```

