# leetcode 19

如果对链表中的节点进行增加或者删除，那么建立一个虚拟头结点指向头结点会简单很多，因为必须要对头结点进行特判，同一个逻辑就可以覆盖所有**合理的**情况。

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        v_head = ListNode()
        v_head.next = head
        p = q = v_head
        for _ in range(n):
            q = q.next
        while q.next:
            p = p.next
            q = q.next
        p.next = p.next.next
        return v_head.next

```

