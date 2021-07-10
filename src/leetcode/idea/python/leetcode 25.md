# leetcode 25

由于本题要求：

你的算法只能使用常数的额外空间。

所以必须考虑迭代解法。

递归本质是调用内置栈完成的，可以考虑使用栈完成，然而我不会这种~~~

我的设想是：反转 k 个元素，然后一直执行这个操作。反转前要考虑剩余元素的个数，看是否需要反转。

```python
def reverseKGroup(self, head: ListNode, k: int) -> ListNode:

    # 反转 k 个元素，返回反转后的头、尾节点。
    def revrese(head, k):
        pre, cur = None, head
        for _ in range(k):
            cur.next, pre, cur = pre, cur, cur.next
        return pre, head

    pre = dummy = ListNode(0)
    dummy.next = head

    while pre.next:
        
        # 判断剩余节点个数是否有 k 个，若没有直接返回。
        # 另一个目的是将 cur 定位到 k+1 个节点的位置，方便后续的拼接。    
        cur = pre.next
        for _ in range(k):
            if not cur:
                return dummy.next
            cur = cur.next

        pre.next, pre = revrese(pre.next, k)  # 将 pre 连接已经反转好的元素，顺便移动 pre 的位置。
        pre.next = cur  # 拼接剩余元素，否则无法继续迭代。

    return dummy.next

```

