# leetcode 24

首先我们用考虑把大象装进冰箱分几步法考虑这个题。

我们要做的就是找到4个点：

头（可以是空）
点1
点2
尾（可以是空）
当前：头（可以是空）-> 点1 -> 点2 -> 尾（可以是空）
目标：头（可以是空）-> 点2 -> 点1 -> 尾（可以是空）

我们需要干的活儿：
步1. 让头指向点2
步2. 让点2指向点1
步3. 让点1指向尾

然后就是，最开始其实是空的。所以先搞一个假头装上。
最后返回的时候再从假头后面开始返回链表就ok啦。

```python
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:

        h = ListNode(0)
        h.next = head  # 假头

        temph = h  # 指针指向当前的头

        while temph.next and temph.next.next:  # 存在点1和点2
            node1 = temph.next
            node2 = temph.next.next

            temph.next = node2   # 步1
            node1.next = node2.next  # 步2
            node2.next = node1  # 步3

            temph = node1  # 移动指针，指向新的头

        return h.next

```

