# leetcoce 9

### 解题思路

\#双指针
首先如果x为负数，直接判定为负
定义左右两个指针，当左指针小于右指针时，循环判定左右是否相等。

```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        x = str(x)
        n = len(x)
        left = 0
        right = n-1
        if x[0] == "-":
            return False
        while left < right:
            if x[left] != x[right]:
                return False
            left += 1
            right -= 1
        return True
            
```

