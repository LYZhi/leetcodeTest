# LeetCode 15

### 题目

![image-20201005120103315](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201005120151.png)

### 题解

此题与18题的四数求和相同

```JAVA
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            if (len < 3) {
                return ans;
            }
            for (int i = 0; i < len - 2; i++) {
                if(i!=0&&nums[i] == nums[i-1]){
                    continue;
                }
                int left = i+1;
                int right = len-1;
                //当前最大值小于0，则将i++
                //当前最小值大于0，退出循环
                if(nums[i]+nums[len-1]+nums[len-2] <0){
                    continue;
                }else if(nums[i]+nums[i+1]+nums[i+2] >0){
                    break;
                }
                while (left<right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if (sum == 0){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        while (left<right&&left<len&&nums[left] == nums[left-1]){
                            left++;
                        }
                        while ((left<right&&nums[right] == nums[right+1])){
                            right--;
                        }
                    }else if (sum<0){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
```

