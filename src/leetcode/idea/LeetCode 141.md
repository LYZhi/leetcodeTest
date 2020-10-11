# LeetCode 141 快慢指针

### 题目

![image-20201010093022297](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011111143.png)

![image-20201010093042501](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011111149.png)

![image-20201010093058608](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201011111157.png)

### 题解一

使用哈希表

```JAVA
public boolean hasCycle(ListNode head) {
        Set<ListNode> ans = new HashSet<>();
        while(head != null){
            if(!ans.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
```

### 题解二

快慢指针

设计两个指针，一个为当前节点slow，另一个为next节点fast，由我们日常生活中操场跑步可以得知，在环形线路中，当fast节点持续领先时，fast会以反超slow一圈的结果使两者再次相遇，所以我们也在链表中设置快慢两个节点，如果存在环形链表那么二者就会相遇。

```JAVA
public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
```

