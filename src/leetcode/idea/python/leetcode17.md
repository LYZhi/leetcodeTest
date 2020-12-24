# leetcode 17

比如："23"
"2":"abc"
"3":"def"
deque:[]
思路：
（1）第一个数字对应的字母先入队列，["a","b","c"]
（2）依次遍历当前队列中的字母，将下一个digits的数字对应的字母和当前队列中的字母进行组合进入队列
（3）直接看代码吧

```python
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        ##先定义数字和字母的字典
        dic = {"2":"abc","3":"def","4":"ghi","5":"jkl","6":"mno","7":"pqrs","8":"tuv","9":"wxyz"}
        res = []
        ##特殊条件判断
        if len(digits)==0:
            return res
        ##使用BFS来解决
        deque = collections.deque()
        deque.append("")
        for i in range(len(digits)):
            lens_deque = len(deque)
            for j in range(lens_deque):
                curr_digit  = dic[digits[i]]
                curr_deque_digit = deque.popleft()
                for digit in curr_digit:
                    deque.append(curr_deque_digit+digit)
            print("当前队列中的内容：",deque)  ##这一句就一下明白每次在干啥了
        return list(deque)

```

