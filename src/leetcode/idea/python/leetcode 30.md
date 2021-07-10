# leetcode 30

### 解题思路

字典+滑动窗口
效率并不高

```python
from collections import Counter
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not words: return []
        pattern=Counter(words)
        res=[]
        wsLen=len(words)
        wLen=len(words[0])
        for i in range(len(s)-wLen*wsLen+1):
            cur=[s[i+j*wLen:i+(j+1)*wLen] for j in range(wsLen)]
            if Counter(cur)==pattern: res.append(i)
        return res

```

