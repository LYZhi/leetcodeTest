# leetcode 20

解题思路
1.首先判断括号个数是否为偶数，不是则不可能配对成功。
2.创建字典，表示左右括号的对应关系，此处为左括号在字典中，右括号为值。
3.遍历：如果是左括号->入栈；如果不是左括号—>出栈，并判断出栈的左括号的值（dic里的对应关系）与此次的括号（c）是否一致：若一致则配对成功。

```python
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)%2==1:
            return False

        dic ={ '(':')', '[':']', '{':'}'}     # 创建字典，表示左右括号的对应关系

        stack = []
        for c in s:
            if c in dic:
                stack.append(c)
            else:
                if len(stack)==0:     #判断栈为空？
                    return False
                else:
                    top = stack.pop()     #栈顶元素
                    if c != dic[top]:     #进来的括号不等于栈顶左括号对应
                        return False
                  
        return not stack

```

