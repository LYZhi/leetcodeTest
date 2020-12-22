# leetcode 12

解题思路
思路：将数字以及对应的罗马数字按着key进行排列，然后判断输入的数和key值之后进行循环
从输入的数大于第一个key，把对应的罗马数字添加到结果中，直到num为0

```python
class Solution:
    def intToRoman(self, num: int) -> str:
        #时间复杂度O(1),空间复杂度为O(1)
        d = {1000:'M',900:'CM', 500:'D', 400:'CD', 100:'C', 90:'XC', 50:'L', 40:'XL', 10:'X', 9:'IX', 5:'V', 4:'IV', 1:'I'}
        result = ''
        for i in d:
            while num >= i:
                num -= i
                result += d[i]
        return result

```

