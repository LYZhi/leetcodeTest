package leetcode.solution;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1238 👎 0


import java.util.ArrayList;
import java.util.List;

class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            back(0, nums, ans, new ArrayList<>());
            return ans;

        }

        private void back(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
            ans.add(new ArrayList<>(temp));
            for (int j = i; j < nums.length; j++) {
                temp.add(nums[j]);
                back(j + 1, nums, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

