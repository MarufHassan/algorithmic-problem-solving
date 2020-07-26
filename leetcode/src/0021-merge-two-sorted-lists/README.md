# [21. Merge Two Sorted Lists][title]

## Problem Description

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Detailed description can be found [here][title].

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

## Solution

**Approach 1: Iterative**

```java
public ListNode mergeTwoLists(ListNode left, ListNode right) {
    if (left == null)
        return right;
    if (right == null)
        return left;
    
    ListNode head = null;
    if (left.val <= right.val) {
        head = left;
        left = left.next;
    } else {
        head = right;
        right = right.next;
    }
    ListNode x = head, temp;
    while (left != null || right != null) {
        if (left == null) {
            x.next = right;
            right = right.next;
        } else if (right == null) {
            x.next = left;
            left = left.next;
        } else if (left.val <= right.val) {
            temp = left;
            left = left.next;
            x.next = temp;
        } else {
            temp = right;
            right = right.next;
            x.next = temp;
        }
        x = x.next;
    }
    return head;
}
```

**Approach 2: Recursive**

```java
public ListNode mergeTwoLists(ListNode left, ListNode right) {
    if (left == null)
        return right;
    if (right == null)
        return left;
    if (left.val <= right.val) {
        left.next = mergeTwoLists(left.next, right);
        return left;
    } else {
        right.next = mergeTwoLists(left, right.next);
        return right;
    }
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

[title]: https://leetcode.com/problems/merge-two-sorted-lists/