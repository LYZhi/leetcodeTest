# leetcode 3

解题思路
题目需要找最长的无重复子串，既然是连续子串，那么可以考虑子串的结尾位置，用来代表一段子串。为了达到不重复，我们可以用字典来做到去重的效果。具体做法如下：

定义 longestlongest, endend 分别记录最长子串的结果和上一次出现重复字符的最后一个位置

如果新的字符在字典中，那么 endend 需要更新为 \max{}{end, dic[c]}maxend,dic[c]。这是由于如果 dic[c] < enddic[c]<end 那就没必要更新。比如字符串 pwwppwwp，在第二个 pp 处， end = 1end=1，而 dic[p] = 0dic[p]=0， 如果 endend 更新为 00，就会代表出现重复的 ww，因此 endend 取最大值更新。

每次更新完 endend 和 longestlongest 值以后，再把当前字符的结尾位置更新到字典中

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        longest = 0
        end = -1
        dic = {}
        for i, c in enumerate(s):
            if c in dic:
                end = max(end, dic[c])
            longest = max(longest, i - end)
            dic[c] = i
        return longest

```

