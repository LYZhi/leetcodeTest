# LeetCode 234

### 题目

![image-20201024110334787](https://raw.githubusercontent.com/LYZhi/Images/master/img/20201024111156.png)

### 题解一：暴力法

将链表中的数据取出存储在list中，然后在list中使用双指针进行遍历，从而达到判断是否为回文的目的

```JAVA
class Solution {
        public boolean isPalindrome(ListNode head) {

            ArrayList ans = new ArrayList();
            ListNode temp = head;
            while (temp != null) {
                ans.add(temp.val);
                temp = temp.next;
            }
            int len = ans.size();
            int i = 0;
            int j = len - 1;
            for (; i <= j; i++, j--) {
                if (ans.get(i).equals(ans.get(j))) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
```

#### 复杂度分析

时间复杂度：O(N)遍历链表的时间复杂度为链表的长度n

空间复杂度：O(N)此方法使用了一个list存储链表中的值，而链表中的值的数量为链表长度n

### 题解二：翻转链表

我们可以通过快慢指针来达到获得回文中点的目的，然后将后半段链表翻转，随后，将翻转的链表和前半段链表进行比较，最后将翻转的部分链表再次翻转回来

```JAVA 
class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 再次翻转链表实现还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        //翻转链表
        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            //快慢指针找到需要翻转处节点
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
```

#### 复杂度分析

时间复杂度：O(N)遍历了整个链表

空间复杂度：O(1)我们只会修改原本链表中节点的指向，而在堆栈上的堆栈帧不超过 O(1)

### 题解三：hash

[膜拜大佬的做法](https://leetcode-cn.com/problems/palindrome-linked-list/solution/ha-xi-bian-li-yi-ci-jiu-xing-by-tcan1993/)

```JAVA 
class Solution {
        public boolean isPalindrome(ListNode head) {
            long hash1 = 0, hash2 = 0, h = 1;
            long seed = (long) (1e9 + 7);
            ListNode p = head;
            while (p != null) {
                hash1 = hash1 * seed + p.val;
                hash2 = hash2 + h * p.val;
                h *= seed;
                p = p.next;
            }
            return hash1 == hash2;
        }
    }
```

