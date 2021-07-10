# leetcode 28

解题思路
lens表示needle的字符串长度
循环次数：haystack减去needle的字符串长度+1
当循环到haystack中第i个字符与needle第一个字符相同时，判断needle与haystack中从下标i开始长度为lens的字符串切片是否相等。若相等，返回i
运行时间44ms，内存消耗15MB

```python
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        lens = len(needle)
        if lens == 0:
            return 0
        for i in range(len(haystack)-lens+1):
            if haystack[i] == needle[0]:
                if haystack[i:i+lens] == needle:
                    return i
                    break
            else:
                continue
        return -1

```

