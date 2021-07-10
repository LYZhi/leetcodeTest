# leetcode 27

说是删除，其实删除很费时间。
双指针其实就是两个数，分别代表两个index，表示数组中第几个数的意思。
比如这里，我们让a代表一个index，b代表一个index
然后我们让a一直往后移动，相当于nums[a]从数组第一个数遍历到最后一个数。
当且仅当我们发现nums[a] != val的时候，我们把这个数拷贝到b指向的位置，默认b是从0开始的，然后b += 1指向下一个位置。

这样我们就保证了前b个数，就是我们要的结果。不重复的数。
99.33%的时间效率。诶哟不错哦。

```python
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        a = 0
        b = 0

        while a < len(nums):
            if nums[a] != val:
                nums[b] = nums[a]
                b += 1
            a += 1

        return b

```

