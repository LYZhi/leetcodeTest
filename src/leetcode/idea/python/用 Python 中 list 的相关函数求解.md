## leetcode 1

用 Python 中 list 的相关函数求解
方法一：
解题关键主要是想找到 num2 = target - num1，是否也在 list 中，那么就需要运用以下两个方法：

num2 in nums，返回 True 说明有戏
nums.index(num2)，查找 num2 的索引
Python

```python
def twoSum(nums, target):
    lens = len(nums)
    j=-1
    for i in range(lens):
        if (target - nums[i]) in nums:
            if (nums.count(target - nums[i]) == 1)&(target - nums[i] == nums[i]):#如果num2=num1,且nums中只出现了一次，说明找到是num1本身。
                continue
            else:
                j = nums.index(target - nums[i],i+1) #index(x,i+1)是从num1后的序列后找num2                
                break
    if j>0:
        return [i,j]
    else:
        return []
```

执行通过，不过耗时较长，共 1636ms。

方法二：
解题思路是在方法一的基础上，优化解法。想着，num2 的查找并不需要每次从 nums 查找一遍，只需要从 num1 位置之前或之后查找即可。但为了方便 index 这里选择从 num1 位置之前查找：

Python

```python
def twoSum(nums, target):
    lens = len(nums)
    j=-1
    for i in range(1,lens):
        temp = nums[:i]
        if (target - nums[i]) in temp:
            j = temp.index(target - nums[i])
            break
    if j>=0:
        return [j,i]
```

