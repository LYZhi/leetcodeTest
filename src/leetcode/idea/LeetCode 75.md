# LeetCode 75

### 题目

![image-20201007123124209](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201007124732.png)

### 题解一 直接计数法

遍历数组，记录有多少个0，多少个1，剩余的就是2的个数

再次遍历数组，逐个按顺序将0,1,2存入数组中

```JAVA 
public void sortColors(int[] nums) {
            int len = nums.length;
            int j = 0, k = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    j++;
                } else if (nums[i] == 1) {
                    k++;
                }
            }

            for (int i = 0; i < len; i++) {
                if (j > 0) {
                    nums[i] = 0;
                    j--;
                } else if (k > 0) {
                    nums[i] = 1;
                    k--;
                } else {
                    nums[i] = 2;
                }
            }

        }
```

### 题解二 双指针计数

定义两个指针和一个计数器，当计数器=0时，与左指针交换位置，当计数器=2时，与右指针交换位置

```java
public void sortColors(int[] nums) {
            int i = 0, j = nums.length - 1;  //定义双指针
            int count = 1;
            while (count <= j) {   //当计数器超过后指针说明已将所有数字归位
                if (nums[count] == 0) {
                    swap(nums, count, i);
                    i++;   //i指针右移
                    count++;
                } else if (nums[count] == 2) {
                    swap(nums, count, j);
                    j--;  //j指针左移

                } else {
                    count++;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
```

### 题解三 快排

解题思路[参考](https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/)

```JAVA
        public void sortColors(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }
            // all in [0, zero] = 0
            // all in (zero, i) = 1
            // all in (two, len - 1] = 2

            // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
            // 所以下面遍历到 0 的时候，先加，再交换
            int zero = -1;

            // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
            // 所以下面遍历到 2 的时候，先交换，再减
            int two = len - 1;
            int i = 0;
            // 当 i == two 的时候，还有一个元素还没有看，
            // 因此，循环可以继续的条件是 i <= two
            while (i <= two) {
                if (nums[i] == 0) {
                    zero++;
                    swap(nums, i, zero);
                    i++;
                } else if (nums[i] == 1) {
                    i++;
                } else {
                    swap(nums, i, two);
                    two--;
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
```



