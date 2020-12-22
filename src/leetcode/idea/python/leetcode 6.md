# leetcode 6

```python
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows <= 1:return s
        array = [s for i in range(numRows)]
        """
        拿题目用例 LEETCODEISHIRING 举例子
        这里的array是这样的：
        ['LEETCODEISHIRING',
         'LEETCODEISHIRING', 
         'LEETCODEISHIRING']
        """
        ans = [list() for i in range(numRows)]
        """
        ans用来存array里我们需要的字符
        最后，ans里面将会是这样的：
        [['L', 'C', 'I', 'R'],
         ['E', 'T', 'O', 'E', 'S', 'I', 'I', 'G'], 
         ['E', 'D', 'H', 'N']]
        """
        i, direction = 0, 1
        for j in range(len(s)):
            ans[i].append(array[i][j])
            i += direction
            if i == 0 or i == numRows - 1:  
                direction *= -1
        result = list()
        for i in ans:
            result.extend(i)
        """
        result 存的是：
        ['L', 'C', 'I', 'R', 'E', 'T', 'O', 'E', 'S', 'I', 'I', 'G', 'E', 'D', 'H', 'N']
        """

        #   最后转换成字符串返回
        return ''.join(result)

```

