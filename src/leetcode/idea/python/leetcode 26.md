# leetcode 26

快慢指针，两数相同，快指针向后走，发现不同时，把快指针指向的元素覆盖慢指针指向的元素即可。
最后切片统一返回，我看有的朋友在对比的过程中，如发现相同元素时会删除该元素，
列表的删除操作时间复杂度是**O(n)**的，不划算。
最后切片统一处理的方法相对来说会比较好些。



```python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1: return n
        # i慢 j快
        i, j = 0, 1
        for inx in range(n - 1):
            if nums[i] == nums[j]:
                j += 1
                continue
            else:
                i += 1
                nums[i] = nums[j]
                j += 1
        nums = nums[0:i + 1]
        return len(nums)


```

