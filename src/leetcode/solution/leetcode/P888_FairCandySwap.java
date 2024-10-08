package leetcode.solution.leetcode;

import java.util.*;

/**
 * @author LYZhi
 * @date 2021/2/2 上午11:08
 */
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。
//
//
//
// 示例 1：
//
//
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：A = [2], B = [1,3]
//输出：[2,3]
//
//
// 示例 4：
//
//
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// 1 <= B.length <= 10000
// 1 <= A[i] <= 100000
// 1 <= B[i] <= 100000
// 保证爱丽丝与鲍勃的糖果总量不同。
// 答案肯定存在。
//
// Related Topics 数组
// 👍 145 👎 0


//公平的糖果棒交换

public class P888_FairCandySwap {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P888_FairCandySwap().new Solution();
        int[] A = {1,3};
        int[] B = {2};
        System.out.println(Arrays.toString(solution.fairCandySwap(A, B)));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();

            int temp = (sumA - sumB)/2;
            Set set = new HashSet();
            for (int num : A){
                set.add(num);
            }
            int[] ans = new int[2];
            for (int y:B){
                int x = y+temp;
                if (set.contains(x)){
                    ans[0] = x;
                    ans[1] = y;
                }
            }
            return ans;

        }
    }
     */

    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();
            int temp = (sumA - sumB) / 2;
            Arrays.sort(A);
            Arrays.sort(B);
            int i = 0, j = 0;
            int[] ans = new int[2];
            while (i < A.length && j < B.length) {
                if (A[i] - B[j] == temp) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    break;
                } else if (A[i] - B[j] > temp) {
                    j++;
                } else {
                    i++;
                }
            }
            return ans;

        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
