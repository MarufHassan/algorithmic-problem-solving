# [2. Add Two Numbers][title]

## Problem Description

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Detailed description can be found [here][title].

**Example:**

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.
```

## Solution

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int n1 = 0, n2 = 0, sum = 0, carry = 0;
    ListNode head = new ListNode(0), result = head;
    while (l1 != null ||  l2 != null) {
        n1 = (l1 == null) ? 0 : l1.val;
        n2 = (l2 == null) ? 0 : l2.val;
        
        sum = n1 + n2 + carry;
        carry = sum / 10;
        
        result.next = new ListNode(sum % 10);
        result = result.next;
        
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }
    if (carry != 0)
        result.next = new ListNode(carry);
    return head.next;
}
```

**Definition for singly-linked list**

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-two-numbers/