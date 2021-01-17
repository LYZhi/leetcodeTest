# leetcode 8

解题思路
此处撰写解题思路
第一：空字符串和全是空格的单独处理

有着这几组的测试数据1:“ 123”，2："hshhs 123456", 3:"-12356" , 4:"-+132456", 5:"+123456" 6:"+-1231456"
不管怎么考虑首先是考虑如何测得除空格外的字符是否符合数字和+-,所以第一步是去掉最右边的所有空格字符然后才能来比较
去掉字符就要比较第一个字符是数字还是正负号，数字直接用字符串连接起来，正负号可以用一个变量来表示，例如 a = 0正号就相加1负号就-1
并不连接字符串
如果第一位是数字就不变
如果不是就返回0

接下来循环判断剩余的，如果是数字就拼接字符串，否则退出

最后将字符串转换成数字进行比较输出

```python
class Solution(object):
    def myAtoi(self, s):
        s = s.lstrip()
        if len(s) == 0:

            return 0

        string = ""

        min = 0

        if s[0] == "-":

            min -= 1

            for i in range(1, len(s)):

                if s[i] >= '0' and s[i] <= '9':

                    string += s[i]
                else:
                    break

        elif s[0] >= '0' and s[0] <= '9':

            for i in range(len(s)):

                if s[i] >= '0' and s[i] <= '9':

                    string += s[i]

                else:
                    break
        elif s[0] == "+":

            min += 1

            for i in range(1, len(s)):

                if s[i] >= '0' and s[i] <= '9':

                    string += s[i]
                else:
                    break
        else:
            return 0

        if len(string) == 0:
            return 0

        a = int(string)

        if a <= 2147483647 and a >= - 2147483648:

            if min >= 0:

                return a

            else:

                return -a

        else:
            if min >= 0:
                return 2147483647

            else:
                return -2147483648

```

