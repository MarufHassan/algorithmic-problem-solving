# [206. Reverse Linked List][title]

## Problem Description

Reverse a singly linked list. [here][title]

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

## Solution

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, next, curr = head;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
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

[title]: https://leetcode.com/problems/reverse-linked-list/