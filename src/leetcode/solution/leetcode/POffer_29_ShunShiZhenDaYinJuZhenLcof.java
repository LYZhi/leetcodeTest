package leetcode.solution.leetcode;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 184 👎 0

import java.util.Arrays;

public class POffer_29_ShunShiZhenDaYinJuZhenLcof {


//顺时针打印矩阵

    public static void main(String[] args) {
        //测试代码
        Solution solution = new POffer_29_ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0) {
                return new int[0];
            }
            //定义二维数组边界
            int l = 0;
            int r = matrix[0].length - 1;
            int t = 0;
            int b = matrix.length - 1;

            int num = matrix.length * matrix[0].length;
            int[] ans = new int[num];
            int x = 0;

            while (true) {
                for (int i = l; i <= r; i++) {
                    ans[x++] = matrix[t][i];
                }
                if (++t > b) {
                    break;
                }
                for (int i = t; i <= b; i++) {
                    ans[x++] = matrix[i][r]; // top to bottom.
                }
                if (l > --r) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    ans[x++] = matrix[b][i]; // right to left.
                }
                if (t > --b) {
                    break;
                }
                for (int i = b; i >= t; i--) {
                    ans[x++] = matrix[i][l]; // bottom to top.
                }
                if (++l > r) {
                    break;
                }

            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}