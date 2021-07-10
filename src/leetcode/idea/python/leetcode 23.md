# leetcode 23

最暴力的做法是把N个数放到一个数组里，再一起排序，O(NlogN)。

当然由于k个链表是有序的，我们实际上只需要维护k个指针从k个链表的头向尾滑动，每次选取k个链表的表头里的最小加入新的有序链表里。

这里我们就可以借用最小堆(优先队列)维护k个链表的当前头位置的值。

时间复杂度就变成O(N*logK)

```python
class Solution(object):
    def mergeKLists(self, lists):
        import heapq
        que = []
        for node in (lists):
            if node != None : 
                heapq.heappush(que ,(node.val, node))
        dummy_node = ListNode(-1)
        cur = dummy_node
        while que:
            val, node =  heapq.heappop(que)
            cur.next = node
            cur = cur.next
            if node.next != None:
                heapq.heappush(que, (node.next.val, node.next))
        return dummy_node.next

```

