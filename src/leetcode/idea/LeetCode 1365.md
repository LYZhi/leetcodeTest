# LeetCode 1365

### 题目

![image-20201026085324695](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201026090254.png)

![image-20201026085341355](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201026090301.png)

### 题解一：暴力法

我们可以选择遍历所有数组，将每一个都与其他数字进行比较，要是小于就进行记录

```JAVA
class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];

            for (int i = 0; i < len; i++) {
                int temp = 0;
                for (int j = 0; j < len; j++) {
                    if (nums[i] > nums[j]) {
                        temp++;
                    }
                }
                ans[i] = temp;
            }
            return ans;
        }
    }
```

#### 复杂度分析

时间复杂度：O(N^2)  将数组遍历了两遍

空间复杂度：O(1) 官方题解说，不计算答案数组的空间占用。

### 题解二：计数排序

由于题目给出了nums数组的大小在1~100之间，那么我们可以之间创建一个101大小的数组temp，将nums中出现的数据在temp中进行记录，然后统计出到temp[i]时，已经出现了多少个小于等于temp[i]的数字，则temp[i-1]就是题目所要求的比nums[i]要小的数字的个数

```JAVA
class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] temp = new int[100];
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                temp[nums[i]]++;
            }
            for (int i = 1; i < 100; i++) {
                temp[i] += temp[i - 1];
            }
            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = temp[nums[i] - 1];
            }
            return ans;
        }

    }
```

#### 复杂度分析

时间复杂度：O(N+K)，其中 KK 为值域大小。需要遍历两次原数组，同时遍历一次频次数组 cnt 找出前缀和。

空间复杂度：O(K)。因为要额外开辟一个值域大小的数组。
