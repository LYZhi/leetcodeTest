//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 464 👎 0

package leetcode.solution;

//java:分割等和子集
class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //背包问题
    /*
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

    }*/

    //降维压缩空间

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
//leetcode submit region end(Prohibit modification and deletion)

}
