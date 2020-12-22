# leetcode 7

关键点：
1.判断整数的正负
2.判断反转后的整数是否溢出
步骤：
1.整数转为字符串
2.分别处理正负情况
3.根据是否溢出，返回相应值

```python
class Solution:
    def reverse(self, x: int) -> int:
        s = str(x)
        if s[0] == '-':
            x = int('-' + s[1:][::-1])
        else:
            x = int(s[::-1])
        return x if -2147483648< x <2147483647 else 0

```

