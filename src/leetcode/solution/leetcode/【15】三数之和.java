//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2647 👎 0

package leetcode.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{-2,-1,0,4,1,2,-2};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            if (len < 3) {
                return ans;
            }
            for (int i = 0; i < len - 2; i++) {
                if(i!=0&&nums[i] == nums[i-1]){
                    continue;
                }
                int left = i+1;
                int right = len-1;
                //当前最大值小于0，则将i++
                //当前最小值大于0，退出循环
                if(nums[i]+nums[len-1]+nums[len-2] <0){
                    continue;
                }else if(nums[i]+nums[i+1]+nums[i+2] >0){
                    break;
                }
                while (left<right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if (sum == 0){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        while (left<right&&left<len&&nums[left] == nums[left-1]){
                            left++;
                        }
                        while ((left<right&&nums[right] == nums[right+1])){
                            right--;
                        }
                    }else if (sum<0){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
