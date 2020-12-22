# leetcode 14

解题思路
将输入列表中的最短字符串的长度作为外层循环次数。
遍历列表中第一个字符串前n个字符并在第二层循环中逐一对比其他字符串。

很明显想的太简单了所以结果不怎么样：后面再慢慢参考题解并优化吧。
执行用时：48 ms, 在所有 Python3 提交中击败了29.54%的用户
内存消耗：15 MB, 在所有 Python3 提交中击败了5.01%的用户

PS.
① 注意不要忽略空列表的输入
② 第一次发现for-else跳出外层循环的妙用。

```python
class Solution:
    def longestCommonPrefix(self,strs):
        res = ""
        if strs == []:
            return res
        for i in range(min(list(map(len,strs)))):
            a = strs[0][i]
            
            for ii in strs:
                if ii[i] != a:
                    break
            else:
                res += a
                continue
            break
        return res


```

