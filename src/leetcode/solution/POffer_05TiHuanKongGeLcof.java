//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 48 👎 0

package leetcode.solution;

//java:替换空格
class POffer_05TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new POffer_05TiHuanKongGeLcof().new Solution();
        String s = "We are happy.";
        System.out.println(solution.replaceSpace(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        public String replaceSpace(String s) {
            String ans = s.replaceAll(" ","%20");
            return ans;
        }

         */
        public String replaceSpace(String s) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0;i<s.length();i++){
                if (s.charAt(i) == ' '){
                    ans.append("%20");
                }else {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
