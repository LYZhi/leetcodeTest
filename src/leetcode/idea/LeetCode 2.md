# LeetCode 2

### 题目

![image-20201004162300213](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201004163334.png)

### 题解

根据题目的描述，我们可以通过处理进位的方式进行相加计算

- 定义ans链表为返回答案链表，定义两个指针，均指向ans链表，一个随着计算而向后移动，另一个一直指向头部，方便最后计算完成后进行返回

- 同时遍历两个链表，定义进位位`carry`

  - 将当前节点的值的和以进位位值相加：`sum=carry+l1.val+l2.val`，sum的个位就是ans链表的当前位值,`carry = sum /10`是当前数值的十位部分
  - 当carry位为1时，就代表发生了进位，所以ans.next（carry）——为了保证当三位数相加时出现第四位的进位

  ```JAVA 
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode pre = new ListNode(0);
          ListNode cur = pre;
          int carry = 0;
          while(l1 != null || l2 != null){
              int x = l1 == null?0:l1.val;
              int y = l2 == null?0:l2.val;
  
              int sum  = x + y +carry;
              carry = sum /10;
              sum = sum %10;
              cur.next = new ListNode(sum);
              cur = cur.next;
              if(l1 != null){
                  l1 = l1.next;
              }
              if(l2 != null){
                  l2 = l2.next;
              }
              if(carry == 1){
                  cur.next = new ListNode(carry);
              }
          }
          return pre.next;
      }
  ```

  ### 具体实现——LIST

  在idea进行具体实现时，需要建立一个创建list链表的方法

  ```JAVA
  //创建list链表
      public ListNode creatList(String listValues){
          //将string类型的输入转换为数组类型
          String[] values = listValues.split(",");
          int index = 0;
          //将string数组类型，转换为int类型
          ListNode pre = new ListNode(Integer.parseInt(values[index]));
          ListNode list = pre;
          index++;
          while(values.length>index) {
              list.next= new ListNode(Integer.parseInt(values[index]));
              list = list.next;
              index++;
          }
          return pre;
      }
  ```

  