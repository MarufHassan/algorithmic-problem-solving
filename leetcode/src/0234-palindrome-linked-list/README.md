# [234. Palindrome Linked List][title]

## Problem Description

Given a singly linked list, determine if it is a palindrome.

Detailed description can be found [here][title]

**Example 1:**

```
Input: 1->2
Output: false
```

**Example 2:**

```
Input: 1->2->2->1
Output: true
```

## Solution

```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    if (fast != null)
        slow = slow.next;
    ListNode tail = reverse(slow);
    while (tail != null) {
        if (head.val != tail.val)
            return false;
        head = head.next;
        tail = tail.next;
    }
    return true;
}
```

**Helper Method**

```java
private ListNode reverse(ListNode x) {
    ListNode prev = null, curr = x, next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

**Definition for singly-linked list.**

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/palindrome-linked-list/