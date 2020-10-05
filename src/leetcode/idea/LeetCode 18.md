# LeetCode 18

题目

![image-20201005115245781](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201005115946.png)

### 题解

1. 将数组排序

2. 定位第一层遍历的指针X

   1. 针对X与target进行最小值最大值的判断

      ```JAVA
      if (target < nums[x] + nums[x + 1] + nums[x + 2] + nums[x + 3]) {
                          break;
                      } else if (target > nums[x] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                          continue;
                      }
      ```

      

   2. 定义第二层遍历的指针Y

      1. 进行针对X与Y的最大值最小值判断

         ```JAVA
         if (target < nums[x] + nums[y] + nums[y + 1] + nums[y + 2]) {
                                 break;
                             } else if (target > nums[x] + nums[y] + nums[len - 2] + nums[len - 1]) {
                                 continue;
                             }
         ```

      2. 进行第三层循环遍历——定义left，right指针

         在第三层进行具体的比较，同时在满足条件时，需要进行去重操作

         ```JAVA 
         result.add(Arrays.asList(nums[x], nums[y], nums[left], nums[right]));
                                     left++;
                                     right--;
                                     while (left<right&&nums[left] == nums[left - 1]) {
                                         left++;
                                     }
                                     while (left<right&&right != len - 1 && nums[right] == nums[right + 1]) {
                                         right--;
                                     }
         ```

         