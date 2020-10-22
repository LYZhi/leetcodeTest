//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 327 👎 0

package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//java:划分字母区间
class P763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new P763PartitionLabels().new Solution();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(solution.partitionLabels(S));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] temp = new int[26];
            for (int i = 0; i < S.length(); i++) {
                temp[S.charAt(i) - 'a'] = i;
            }

            List<Integer> ans = new ArrayList<>();
            int end = 0,start = 0;
            for (int i = 0;i<S.length();i++){
                end = Math.max(temp[S.charAt(i)-'a'],end);
                if (i == end){
                    ans.add(end-start+1);
                    end = 0;
                    start = i+1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
