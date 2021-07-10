# leetcode 16

这题和三数之和接近，就是排序然后再使用双指针。寻找最接近的数，刚好原来的三数之和就是使用慢慢接近的方法寻找target的，所以就可以在寻找target的过程中每一次都判断是否是最接近的。

优化的细节是在双指针前加入当前这一轮，也就是first固定下来后，的最大值和最小值与target的关系。如果最大的数都小于等于target，那直接下一轮，first往右也许能更大；如果最小的数都大于等于target，那压根别找了，因为不可能再有更小的数了，直接Break掉返回结果即可。

```python
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()         # 排序
        ans = float('inf') 

        for first in range(n-2):        # 枚举第一个元素
            if first > 0 and nums[first] == nums[first-1]: continue     # 保证first不会有重复

            second, third = first + 1, n - 1
            max_sum = nums[first] + nums[-2] + nums[-1]
            min_sum = nums[first] + nums[first + 1] + nums[first + 2]
            if max_sum <= target:    # 最大的数
                if abs(max_sum - target) < abs(ans - target):
                    ans = max_sum
                continue              
            elif min_sum >= target:  # 最小的数
                if abs(min_sum - target) < abs(ans - target):
                    ans = min_sum      
                break   
                      
            while second < third:
                two_sum_target = target - nums[first]
                s = nums[second] + nums[third]
                if abs(s + nums[first] - target) < abs(ans - target):
                    ans = s + nums[first]
                if s > two_sum_target:  # 当前数值太大 右指针左移
                    third -= 1
                    while third > second and nums[third] == nums[third + 1]:
                        third -= 1
                elif s < two_sum_target:  # 当前数值太小 左指针右移
                    second += 1
                    while third > second and nums[second] == nums[second - 1]:
                        second += 1 
                else:                   # 刚好等于 直接返回target即可
                    return target 

        return ans

```

