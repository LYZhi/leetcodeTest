# Offier 03

### 题目

![image-20201102132631960](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201102135215.png)

### 题解一 hashset

将数组中的数据放入hash中，当遇到重复数组时，返回当前值

```JAVA
public int findRepeatNumber(int[] nums) {
    Set ans = new HashSet();
    for (int num : nums){
        if (!ans.add(num)){
            return num;
        }
    }
    return -1;
}
```

#### 复杂度分析

时间复杂度：O(n) 遍历一遍数组，在哈希中添加数组的复杂度为O（1），所以遍历一遍时间复杂度为O(n)

空间复杂度：不重复的数组都可以存入集合中，占用O（n)的额外空间

### 题解二 排序

由题目可知，长度为n 的 nums数组中值为从0~n-1,所以当没有重复的值时，意味着我们可以通过 将值 i 放入对应的nums[i] 中的方式去排序，当存在nums[i] != i,但 nums[nums[i]] == nums[i] ，便意味着有重复的数据产生了

```JAVA
		public int findRepeatNumber(int[] nums) {
            int temp = 0;
            for (int i = 0;i< nums.length;i++){
                while (nums[i] != i){
                    if (nums[nums[i]] == nums[i]){
                        return nums[i];
                    }
                    temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return -1;
        }
```

#### 复杂度分析

时间复杂度：O(n)

空间复杂度：O(1) 额外空间为1