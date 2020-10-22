# LeetCode 763

### 题目

![image-20201022163222677](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201022164635.png)

### 题解

此题可以先第一次遍历，利用**数组**将每个数的最后出现位置记录下来

```JAVA
int[] temp = new int[26];
for (int i = 0; i < S.length(); i++) {
	temp[S.charAt(i) - 'a'] = i;
}
```



然后，进行第二次遍历

- 由题目我们可以知道，划分的片段中的字母不能出现在其他片段中，所以，我们可以通过遍历，记录片段开始start和结束end值

- 而end的确认方式就是 end>=当前已存在字母中的最后出现位置的最大值。即

	```JAVA
	end = Math.max(temp[S.charAt(i)-'a'],end);
	```

	

- 当遍历的当前i == end时，此时当前片段结束，将此片段进行存储，并且更新start的开始值

	```JAVA
	if (i == end){
	    ans.add(end-start+1);
	    start = i+1;
	}
	```

	

### 复杂度分析

时间复杂度 O(n)：由于我们进行了两次循环遍历，而遍历长度是S.length()

空间复杂度O(26)：我们构建了一个长度为26的数组进行存储字母最后出现的位置