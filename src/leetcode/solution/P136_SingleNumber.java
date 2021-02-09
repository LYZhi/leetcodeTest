package leetcode.solution;

/**
 * @author LYZhi
 * @date 2021/2/9 上午10:54
 */
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1689 👎 0


//只出现一次的数字

public class P136_SingleNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P136_SingleNumber().new Solution();
        int[] ans = {4,12,12};
        System.out.println(solution.singleNumber(ans));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    //位运算！！
    class Solution {
        public int singleNumber(int[] nums) {
            int num=0;
            for(int i=0;i<nums.length;i++){
                num=num^nums[i];
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}