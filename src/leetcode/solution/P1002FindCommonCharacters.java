//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 162 👎 0

package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:查找常用字符
class P1002FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new P1002FindCommonCharacters().new Solution();

        String[] A = new String[] {"bella","label","roller"};
        System.out.println(solution.commonChars(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            int[] minTemp = new int[26];
            Arrays.fill(minTemp, Integer.MAX_VALUE);
            for (String num : A) {
                int[] temp = new int[26];
                for (int i = 0; i < num.length(); i++) {
                    char c = num.charAt(i);
                    temp[c - 'a']++;
                }

                System.out.println("hi");
                for (int i = 0; i < temp.length; i++) {
                    minTemp[i] = Math.min(minTemp[i], temp[i]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < minTemp[i]; ++j) {
                    System.out.println(minTemp[i]);
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
