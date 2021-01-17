//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
//
//
// 示例：
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10000
//
// 👍 72 👎 0


package leetcode.solution;

import java.util.Arrays;

public class POffer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] nums = {1, 1, 2, 3, 4, 5, 3, 6, 8, 4, 3, 3};
        System.out.println(Arrays.toString(solution.exchange(nums)));

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int[] exchange(int[] nums) {

            int temp = 0;
            int i = 0;

            while (i < nums.length) {

                if ((nums[i]&1)==1) {
                    int a = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = a;
                    temp++;
                }
                i++;
            }
            return nums;
        }
    }


    /**
     class Solution {
     public int[] exchange(int[] nums) {
     int fast = 0, slow = 0;
     while (fast < nums.length) {
     // fast指向一个奇数，进行交换操作
     if (nums[fast] % 2 == 1) {
     int temp = nums[fast];
     nums[fast] = nums[slow];
     nums[slow] = temp;
     // 交换完毕后 slow后移
     slow++;
     }
     fast++;
     }
     return nums;
     }
     }
     */

//leetcode submit region end(Prohibit modification and deletion)

}