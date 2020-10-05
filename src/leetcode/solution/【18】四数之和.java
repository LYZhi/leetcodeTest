//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 595 👎 0

package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:四数之和
class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        int[] nums = new int[]{1,0,0,-1,-2,2};
        int target = 0;

        System.out.println(solution.fourSum(nums,target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            if (nums == null || len < 4) {
                return result;
            }

            for (int x = 0; x < len - 3; x++) {
                if (x != 0 && nums[x] == nums[x - 1]) {
                    continue;
                }
                if (target < nums[x] + nums[x + 1] + nums[x + 2] + nums[x + 3]) {
                    break;
                } else if (target > nums[x] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                    continue;
                }

                for (int y = x + 1; y < len - 2; y++) {
                    if (y > x + 1 && nums[y] == nums[y - 1]) {
                        continue;
                    }
                    if (target < nums[x] + nums[y] + nums[y + 1] + nums[y + 2]) {
                        break;
                    } else if (target > nums[x] + nums[y] + nums[len - 2] + nums[len - 1]) {
                        continue;
                    }

                    int right = len - 1;
                    int left = y + 1;
                    while (right > left) {
                        if (target == nums[x] + nums[y] + nums[left] + nums[right]) {
                            result.add(Arrays.asList(nums[x], nums[y], nums[left], nums[right]));
                            left++;
                            right--;
                            while (left<right&&nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (left<right&&right != len - 1 && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (target < nums[x] + nums[y] + nums[left] + nums[right]) {
                            right--;
                        } else {

                            left++;
                        }

                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
