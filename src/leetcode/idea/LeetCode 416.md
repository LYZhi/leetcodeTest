# LeetCode 416 背包问题

### 题目

![image-20201011111444474](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011111444.png)

![image-20201011111536952](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011111539.png)

### 题解

此题可以看做是一个背包问题——有N个物品，需要放入容量为sum/2的背包中，需要我们知道是否存在一种组合，使得可以成功的将物品放入背包中。

![image-20201011112056262](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011112101.png)

```JAVA
public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int temp = 0;
        if (len == 0) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        } else {
            temp = sum / 2;
        }

        boolean[][] dp = new boolean[len][temp +1];
        if (nums[0] <= temp) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= temp; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][temp];

    }
```

#### 将空间优化

可以将二维数组优化为一维数组，此时J的遍历需要采用逆序形式

```
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int target = 0;
        if (len == 0) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        } else {
            target = sum / 2;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
```



