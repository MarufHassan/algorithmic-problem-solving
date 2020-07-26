# [141. Linked List Cycle][title]

## Problem Description

Reverse a singly linked list.Given a linked list, determine if it has a cycle in it.

Detailed description can be found [here][title].

**Example 1:**

```
Input: head = [3,2,0,-4], pos = 1
Output: true

Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

**Example 2:**

```
Input: head = [1,2], pos = 0
Output: true

Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

**Example 3:**

```
Input: head = [1], pos = -1
Output: false

Explanation: There is no cycle in the linked list.
```

## Solution

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast)
            return true;
    }
    return false;
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

[title]: https://leetcode.com/problems/linked-list-cycle/