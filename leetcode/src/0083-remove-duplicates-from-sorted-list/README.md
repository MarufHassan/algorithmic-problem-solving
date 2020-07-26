# [83. Remove Duplicates from Sorted List][title]

## Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.

Detailed description can be found [here][title].

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```

**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
```

## Solution

**Approach 1**

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode curr = head, next;
    
    while (curr != null) {
        next = curr.next;
        while (next != null && curr.val == next.val)
            next = next.next;
        curr.next = next;
        curr = curr.next;
    }
    return head;
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

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-list/