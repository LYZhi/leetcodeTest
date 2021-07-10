# leetcode 34

解题思路
1.本题的本质是二分搜索，但是是在有重复元素的情况下进行的边界查找。
2.查找左边界，尽量使右边界往左靠，所以当搜索到答案后，令right = mid；
3.查找右边界，使left向右靠，但是当left与right相邻时会出现lefg===mid的情况导致死循环，故需要改变其取整方式，最简单的方法就是改变mid大小（注释中已说明）

```python
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        size = len(nums)
        if size == 0 : return [-1,-1]
        first_pos = self.findFirst(nums,target,size)
        last_pos = self.findLast(nums,target,size)
        if(first_pos == -1):
            return [-1,-1]
        else:
            return [first_pos,last_pos]
    def findFirst(self, nums: List[int], target: int, size:int) -> int:
        left = 0
        right = size-1
        while left < right:
            mid = (left + right) //2
            if nums[mid] < target:
                left = mid+1
            elif nums[mid] == target:
                right = mid 
            else:
                right = mid -1
            
            
        if nums[right]==target:
           return right
        else:
            return -1
    def findLast(self, nums: List[int], target: int, size:int) -> int:
        left = 0
        right = size-1
        while left < right:
            mid = (left + right+1) //2 #因为 left = mid，所以下取整要改为上取整。
            if nums[mid] > target:
                right = mid-1
            elif nums[mid]==target :
                left = mid
            else:
                left = mid +1
            #print(mid)
        
        return left

```

