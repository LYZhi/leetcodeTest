//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归 
// 👍 69 👎 0

package leetcode.solution.leetcode;

//java:斐波那契数列
class POffer_10IFeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new POffer_10IFeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int[] num = {n, 0, 1};
            return ans(num, 1);
        }

        public int ans(int[] n, int num) {
            if (num == n[0]) {
                return n[2];
            }
            num++;
            int temp = n[2];
            n[2] = (n[1] + n[2]) % 1000000007;
            n[1] = temp;
            return ans(n, num);
        }
    }
    /*
    class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
     */
//leetcode submit region end(Prohibit modification and deletion)

}
