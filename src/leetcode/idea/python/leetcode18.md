# leetcode 18

巧妙地将4数之和转为2数之和问题，关键是使用哈希表保存所有可能的两数之和的值，哈希表key为两数之和，值为和为key的数对的下标列表。

需要注意的几点：

算法本身不需要nums先排序，但是为了保证生成的结果顺序一致从而可以去重，依然要先进行排序；
使用python的话，结果要暂存为tuple，因为list是可变不可hash，因此不能用来去重。
时间复杂度可能还是O(n^3)，因为worst case下map.get(target - key)包含n/2个元素，三重循环遍历复杂度为O(n^3)。但是运行时间和加了剪枝的双指针差不多（180ms V.S. 120 ms），这就告诉我们一个道理：理论上的复杂度无法减小的话，加入条件剪枝可以在实际上获得很大的加速。

```python
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        N = len(nums)
        if N < 4:
            return []
        # use set to deduplicate
        res = set()
        nums.sort()
        # sum:[(index1, index2)]
        table = {}

        for i in range(N - 1):
            for j in range(i + 1, N):
                s = nums[i] + nums[j]
                if target - s in table:
                    for tmp in table[target - s]:
                        if tmp[1] < i:
                            # use tuple since it is hashable
                            res.add((nums[tmp[0]], nums[tmp[1]], nums[i], nums[j]))
                if s not in table:
                    table[s] = []
                table[s].append((i, j))
        # convert set to list
        ans = []
        for r in res:
            ans.append(list(r))
        return ans

```

