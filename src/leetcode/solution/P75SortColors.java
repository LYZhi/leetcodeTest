//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 624 👎 0

package leetcode.solution;

import java.util.Arrays;

//java:颜色分类
class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        int[] nums = new int[]{0, 2, 2, 1, 1, 0};
        solution.sortColors(nums);
//        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 直接计数法
         public void sortColors(int[] nums) {
         int len = nums.length;
         int j = 0, k = 0;
         for (int i = 0; i < len; i++) {
         if (nums[i] == 0) {
         j++;
         } else if (nums[i] == 1) {
         k++;
         }
         }

         for (int i = 0; i < len; i++) {
         if (j > 0) {
         nums[i] = 0;
         j--;
         } else if (k > 0) {
         nums[i] = 1;
         k--;
         } else {
         nums[i] = 2;
         }
         }

         }
         */
        /**
         * 双指针计数
         * public void sortColors(int[] nums) {
         * int i = 0, j = nums.length - 1;  //定义双指针
         * int count = 1;
         * while (count <= j) {   //当计数器超过后指针说明已将所有数字归位
         * if (nums[count] == 0) {
         * swap(nums, count, i);
         * i++;   //i指针右移
         * count++;
         * } else if (nums[count] == 2) {
         * swap(nums, count, j);
         * j--;  //j指针左移
         * <p>
         * } else {
         * count++;
         * }
         * }
         * }
         * <p>
         * public void swap(int[] nums, int i, int j) {
         * int temp = nums[i];
         * nums[i] = nums[j];
         * nums[j] = temp;
         * }
         */

        /**
         * 快排思路参考：
         * https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/
         */
        public void sortColors(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }
            // all in [0, zero] = 0
            // all in (zero, i) = 1
            // all in (two, len - 1] = 2

            // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
            // 所以下面遍历到 0 的时候，先加，再交换
            int zero = -1;

            // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
            // 所以下面遍历到 2 的时候，先交换，再减
            int two = len - 1;
            int i = 0;
            // 当 i == two 的时候，还有一个元素还没有看，
            // 因此，循环可以继续的条件是 i <= two
            while (i <= two) {
                if (nums[i] == 0) {
                    zero++;
                    swap(nums, i, zero);
                    i++;
                } else if (nums[i] == 1) {
                    i++;
                } else {
                    swap(nums, i, two);
                    two--;
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
