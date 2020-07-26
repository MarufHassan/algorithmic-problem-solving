# [237. Delete Node in a Linked List][title]

## Problem Description

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. [here][title]

**Example 1:**

```
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

**Example 2:**
```
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]

Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

## Solution

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
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

[title]: https://leetcode.com/problems/delete-node-in-a-linked-list/