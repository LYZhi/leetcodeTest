# leetcode 31

本题关键在于如何找到下一个邻近的排列，如果仅仅是找到一个大的排列，只需要线性扫描到一个更大的数与前面一个数交换即可，但这无法满足邻近这个要求，举个例子来进行说明，如数组[1,2,3,4,5]处于最小排列状态：
(1)在[1,2,3,4,5]这一状态时，通过倒序遍历发现，索引为n-1时便大于前面一个数，此时直接对n-1和n-2的数调换即可；
(2)在[1,2,4,5,3]这一状态时，通过倒序遍历发现，索引为n-2时大于前面一个数，此时若将n-2与其前一个数调换得[1,2,5,4,3]，但显然这虽然是一个更大的排列，但却不是邻近的排列；
(3)在[5,4,3,2,1]这一状态时，直接翻转即可

那么，应该如何操作呢？在(2)中的状态时，我们可以将nums[n-2:]这一部分直接翻转得到[1,2,4,3,5]，这时变成一个更小得邻近得排列了，但不要急，此时若从3开始往后搜索，会发现5大于4，于是进行对调成为[1,2,5,3,4]，这时就变成了邻近最大排列。
同样的方法可以在很多例子中适用，于是可以总结出这样一条规律：
下一个更大的排列首先需要一个邻近的更大的数字替换自身，但同时还需要保证后面的数字组合达到最小才符合邻近标准，因此我们反其道而行之，先保证后面的数字组合达到最小，然后从标记位置向后搜索到一个大于自己的数进行对调，这样就能获取下一个排列。

```python
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        index = 0
        for i in range(len(nums)-1, 0, -1):
            if nums[i] > nums[i-1]:
                index = i
                break
        if index == len(nums)-1:
            nums[index], nums[index-1] = nums[index-1], nums[index]
        elif index == 0:
            self.Reverse(nums, 0, len(nums)-1)
        else:
            self.Reverse(nums, index, len(nums)-1)
            for s in range(index, len(nums)):
                if nums[s] > nums[index-1]:
                    nums[index-1], nums[s] = nums[s], nums[index-1]
                    break
    def Reverse(self, nums, start, end):
        mid = (start+end+1) // 2
        k = 0
        for j in range(start, mid):
            nums[j], nums[end-k] = nums[end-k], nums[j]
            k += 1

```

