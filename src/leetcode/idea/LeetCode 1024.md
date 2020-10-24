# LeetCode 1024

程序员节快乐啊！！一起快乐秃头

### 题目

![image-20201024111810900](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201024113009.png)

![image-20201024111838964](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201024113005.png)

[题解思路](https://leetcode-cn.com/problems/video-stitching/solution/shi-pin-pin-jie-by-leetcode-solution/)

### 题解一：动态规划

我们可以通过逐步的找到 i 之前的最大区间所用的片段数量，在加上本次的，既是i时所用的片段数量

```JAVA
class Solution {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for (int i = 1; i <= T; i++) {
                for (int[] clip : clips) {
                    if (clip[0] < i && i <= clip[1]) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }
            return dp[T] != Integer.MAX_VALUE ? dp[T] : -1;
        }
    }
```

#### 复杂度分析

时间复杂度：O(T×N)，其中 T 是区间的长度，N 是子区间的数量。对于任意一个前缀区间 [0,i) ，我们都需要枚举所有的子区间，时间复杂度 O(N)。总时间复杂度为 O(T×N)。

空间复杂度：O(T)，其中 T 是区间的长度。我们需要记录每一个前缀区间 [0,i) 的状态信息

### 题解二：贪心

由于以同一时间起始的片段，我们只需要保存其中跨度最大的片段就可以了，所以我们可以针对此将原片段进行简化

```JAVA
int[] max = new int[T];
            for (int[] clip : clips) {
                if (clip[0] < T) {
                    max[clip[0]] = Math.max(max[clip[0]], clip[1]);
                }
            }
```

我们记录下当位置到达i时，当前可以到达的最大区间

- 如果当前位置 == 可达到的最大区间，那么意味着后续不会被覆盖，无法实现目标
- 当我们每到达上一个last时，即意味着我们使用完了一个片段，需要对使用的片段进行计数

```JAVA
class Solution {
        public int videoStitching(int[][] clips, int T) {
            int[] max = new int[T];
            for (int[] clip : clips) {
                if (clip[0] < T) {
                    max[clip[0]] = Math.max(max[clip[0]], clip[1]);
                }
            }

            int last = 0;
            int pre = 0;
            int ans = 0;
            for (int i = 0; i < T; i++) {
                last = Math.max(max[i], last);
                if (i == last) {
                    return -1;
                }
                if (i == pre) {
                    pre = last;
                    ans++;
                }
            }
            return ans;
        }

    }
```

