package leetcode.solution;

/**
 * @author LYZhi
 * @date 2021/2/5 上午11:04
 */
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//
//
// 示例：
//
//
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。
//
// Related Topics 数组
// 👍 163 👎 0

//子数组最大平均数 I

public class P643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P643_MaximumAverageSubarrayI().new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(solution.findMaxAverage(nums, 4));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            int j = 0;
            for (; j < k; j++) {
                sum += nums[j];

            }
            int max = sum;
            for (int i = 1; j < nums.length; i++) {

                sum -= nums[i - 1];
                sum += nums[j];
                j++;
                max = Math.max(max, sum);
            }
            return 1.0 * max / k;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}