# LeetCode 501

![image-20200924092646160](https://raw.githubusercontent.com/LYZhi/Images/master/img/20200924094329.png)

### 解题思路

首先我们知道通过中序遍历的方式我们可以得到一个有序的序列，然后我们只要在遍历时依次将树中的数据出现次数进行记录，就可以得到二叉搜索树的众数。

在遍历时的记录方式：

由于二叉搜索树的性质：

1. 结点左子树中所含的结点值小于等于当前结点值
2. 结点右子树中所含的结点值大于等于当前结点值
3. 左右子树都是二叉搜索树

在进行中序遍历时，

1. 只需要判断此节点是否与上一个父节点相同。相同即将此数存在值`thisTime`++，不同则意味着此节点是第一次出现——`thisTime = 1`
2. 判断`thisTime`与`maxTime`之间的关系。当两者相同时，意味着这是两个出现次数相同的数，所以，直接将此节点放入list中，而若`thisTime`>`maxTime`则意味着`thisTime`才是目前为止最大的众数，将list中存在的数据清除，重新将此节点存入list中，并且将`maxTime`的值更新。
3. 记录当前结点位置，方便在递归时进行判断结点出现次数

