//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 210 👎 0

package leetcode.solution;

//java:比较含退格的字符串
class P844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new P844BackspaceStringCompare().new Solution();
        String S = "ad#ac";
        String T = "ae##aac";
        System.out.println(solution.backspaceCompare(S, T));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1;
            int j = T.length() - 1;
            int ansS = 0;
            int ansT = 0;

            while (i >= 0 || j >= 0) {
                //当存在#号时，前移一位
                while (i >= 0) {
                    if (S.charAt(i) == '#') {
                        ansS++;
                        i--;
                    } else if (ansS > 0) {
                        ansS--;
                        i--;
                    } else {
                        break;
                    }
                }

                while (j >= 0) {
                    if (T.charAt(j) == '#') {
                        ansT++;
                        j--;
                    } else if (ansT > 0) {
                        ansT--;
                        j--;
                    } else {
                        break;
                    }
                }

                if (i >= 0 && j >= 0) {
                    if (S.charAt(i) != T.charAt(j)) {
                        return false;
                    }
                } else {
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;
        }

    }


//    class Solution {
//        public boolean backspaceCompare(String S, String T) {
//            if (ans(S).equals(ans(T))) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        public Stack ans(String str) {
//            Stack stack = new Stack();
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) != '#') {
//                    stack.push(str.charAt(i));
//                }else if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//            }
//            return stack;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
