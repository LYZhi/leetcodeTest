# leetcode 15

### 解题思路

坑：
去除重复项：避免越界，且需要与没有重复项时的情况兼容

```python
while j<k and sortnums[k]==sortnums[k-1]:
    k-=1
while j<k and sortnums[j]==sortnums[j+1]:
    j+=1
k-=1
j+=1

```

实现

```python
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sortnums=sorted(nums)
        n=len(nums)
        ans=[]
        for i in range(n):
            if i>0 and sortnums[i]==sortnums[i-1]:
                continue
            j=i+1
            k=n-1
            while j<k:
                if sortnums[j]+sortnums[k]<-sortnums[i]:
                    j+=1
                elif sortnums[j]+sortnums[k]>-sortnums[i]:
                    k-=1
                else:
                    # 注意此处要先剔除重复项
                    ans.append([sortnums[i],sortnums[j],sortnums[k]])
                    while j<k and sortnums[k]==sortnums[k-1]:
                        k-=1
                    while j<k and sortnums[j]==sortnums[j+1]:
                        j+=1
                    k-=1
                    j+=1
        return ans


```

