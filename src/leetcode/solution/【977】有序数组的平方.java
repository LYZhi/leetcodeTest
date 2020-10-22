//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 157 👎 0

package leetcode.solution;

import java.util.Arrays;

//java:有序数组的平方
class P977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        int[] A = new int[]{-4, -3, -1, 0, 6, 9};
        System.out.println(Arrays.toString(solution.sortedSquares(A)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int[] sortedSquares(int[] A) {
//            int len = A.length;
//            //找到正负数的分界线
//            int temp = -1;
//            for (int i = 0; i < len - 1; i++) {
//                if (A[i] < 0) {
//                    temp = i;
//                }
//            }
//            int[] ans = new int[len];
//            int left = temp, right = temp + 1,n = 0;
//            while (left >= 0 || right < len) {
//                if (left<0){
//                    ans[n] = A[right]*A[right];
//                    right++;
//                }else if (right>=len){
//                    ans[n] = A[left]*A[left];
//                    left--;
//                }else if (A[right]*A[right]>=A[left]*A[left]){
//                    ans[n] = A[left]*A[left];
//                    left--;
//                }else {
//                    ans[n] = A[right]*A[right];
//                    right++;
//                }
//                n++;
//            }
//
//            return ans;
//        }
//    }
    class Solution {
        public int[] sortedSquares(int[] A) {
            int n = A.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
                if (A[i] * A[i] > A[j] * A[j]) {
                    ans[pos] = A[i] * A[i];
                    ++i;
                } else {
                    ans[pos] = A[j] * A[j];
                    --j;
                }
                --pos;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
