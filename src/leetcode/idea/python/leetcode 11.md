# leetcode 11

用S(i, j)表示面积(i<j)：S(i, j) = (j – i) * min(a(i), a(j))

1.暴力法是遍历所有S(i, j)找出最大值；
时间复杂度O(n^2)

2.采用从两边向中间靠拢的方法去遍历找最大值，假设下一步是i向内移一步，那么就是从S(i, j)遍历到S(i+1, j)，与此同时，就不会遍历到T = { S(i, j-1), S(i, j-2), …, S(i, i+1)}，如果能证明：

① S(i, j) >= T，那么最大值肯定不会出现在T，不遍历也无所谓；

② S(i+1, j) 可能> S(i, j)，那么最大值一定能遍历到。

证明前有个总结，分析S(i, j)的公式，i, j向中间靠拢的过程中，(j – i)一定是减小的；而min(a(i), a(j))的值是由短边的大小决定的，短边越长，min(a(i), a(j))越大。也就是说，i, j向中间靠拢的过程中，只有短边变长，S(i, j)才有可能增大。

证明：

If a(i)是短边，即a(i) < a(j):

那么将i向内移一步，min(a(i+1), a(j)) 可能> min(a(i), a(j))，那么S(i+1, j) 可能> S(i, j)，②可证。

对于T的元素，移动长边a(j)，不会令短边变长，所以S(i, j-1), S(i, j-2), …, S(i, i+1)都不会比S(i, j) 大，即S(i, j) >= T，①可证。

If a(i)是长边，即a(i) > a(j):

那么将i向内移一步，min(a(i+1), a(j)) <= min(a(i), a(j))，那么S(i+1, j) <= S(i, j)，②证伪。

对于T的元素，移动短边a(j)， S(i, j-1), S(i, j-2), …, S(i, i+1)可能>S(i, j) ，即T 可能>S(i, j) ，①证伪。

结论：移动a(i)和a(j)中的短边向中间靠拢，一定能遍历到最大值，时间复杂读O(n)。

```python
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i = 0
        j = len(height) - 1
        s = 0
        while(i<j):
            s = max(s, (j-i) * min(height[i], height[j]))
            if height[i] < height[j]:
                i = i + 1
            else:
                j = j - 1
        return s


    
```

