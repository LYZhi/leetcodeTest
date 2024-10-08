//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
//
//
//
// 示例 1：
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//
// 示例 2：
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
//
//
//
//
// 提示：
//
//
// 0 <= pushed.length == popped.length <= 1000
// 0 <= pushed[i], popped[i] < 1000
// pushed 是 popped 的排列。
//
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
// 👍 115 👎 0
package leetcode.solution.leetcode;
//栈的压入、弹出序列

/**
 * @author LYZhi
 * @date 2021/1/23 下午5:05
 */
public class POffer_31_ZhanDeYaRuDanChuXuLieLcof {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_31_ZhanDeYaRuDanChuXuLieLcof().new Solution();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
//        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(solution.validateStackSequences(push, pop));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0) {
                return true;
            }
            Stack<Integer> temp = new Stack<>();
            int k = 0;
            for (int num : pushed) {
                temp.push(num);
                while (!temp.isEmpty() && popped[k] == temp.peek()) {
                    k++;
                    temp.pop();
                }
            }
            return temp.isEmpty();
        }
    }
     */

    //O(1) 空间 O(n) 时间
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int i = 0, j = 0;
            for (int e : pushed) {
                //重复使用数组作为堆栈
                pushed[i] = e;
                while (i >= 0 && pushed[i] == popped[j]) {
                    //设置出栈和入栈
                    j++;
                    i--;
                }
                i++;
            }
            return i == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}