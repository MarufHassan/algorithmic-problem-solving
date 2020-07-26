# [445. Add Two Numbers II][title]

## Problem Description

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Detailed description can be found [here][title].

**Example 1:**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```

## Solution

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> augend = new Stack<>();
    Stack<Integer> addened = new Stack<>();
    ListNode x = l1, head;
    while (x != null) {
        augend.push(x.val);
        x = x.next;
    }
    
    x = l2;
    while (x != null) {
        addened.push(x.val);
        x = x.next;
    }
    
    head = new ListNode(0);
    int sum = 0;
    while (!augend.empty() || !addened.empty()) {
        if (!augend.empty())
            sum += augend.pop();
        if (!addened.empty())
            sum += addened.pop();
        head.val = sum % 10;
        x = new ListNode(sum / 10);
        x.next = head;
        head = x;
        sum /= 10;
    }
    
    return head.val == 0 ? head.next : head;
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

[title]: https://leetcode.com/problems/add-two-numbers-ii/