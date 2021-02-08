package leetcode.solution;

/**
 * @author LYZhi
 * @date 2021/2/8 上午10:04
 */
//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
//
//
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
//
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
//
// 返回 A 的最大湍流子数组的长度。
//
//
//
// 示例 1：
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
//
//
// 示例 2：
//
// 输入：[4,8,12,16]
//输出：2
//
//
// 示例 3：
//
// 输入：[100]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 40000
// 0 <= A[i] <= 10^9
//
// Related Topics 数组 动态规划 Sliding Window
// 👍 94 👎 0

//最长湍流子数组

public class P978_LongestTurbulentSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P978_LongestTurbulentSubarray().new Solution();
        int[] num = {9, 9, 2};
        System.out.println(solution.maxTurbulenceSize(num));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    class Solution {
        public int maxTurbulenceSize(int[] arr) {

            int maxWindos = 1;
            int j = 0;
            int flag = 0;

            for (int i = 0; i < arr.length; i++) {
                if (maxWindos > arr.length - j + 1) {
                    break;
                }
                if (i == arr.length - 1) {
                    maxWindos = Math.max(maxWindos, i - j + 1);
                    break;
                }

                if (arr[i] == arr[i + 1]) {
                    maxWindos = Math.max(maxWindos, i - j + 1);
                    j = i + 1;
                    flag = 0;
                    continue;
                }


                if (arr[i] < arr[i + 1]) {
                    if (flag == 0) {
                        flag = 1;
                    } else if (flag == 1) {
                        maxWindos = Math.max(maxWindos, i - j + 1);
                        j = i;
                    } else {
                        flag = 1;
                    }
                } else {
                    if (flag == 0) {
                        flag = -1;
                    } else if (flag == -1) {
                        maxWindos = Math.max(maxWindos, i - j + 1);
                        j = i;
                    } else {
                        flag = -1;
                    }
                }

            }
            return maxWindos;
        }
    }

     */

    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int len = arr.length;
            int up = 1, down = 1;
            int ans = 1;
            for (int i = 1; i < len; i++) {
                if (arr[i] > arr[i - 1]) {
                    up = down + 1;
                    down = 1;
                } else if (arr[i] < arr[i - 1]) {
                    down = up + 1;
                    up = 1;
                } else {
                    up = down = 1;
                }
                ans = Math.max(ans, Math.max(up, down));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
