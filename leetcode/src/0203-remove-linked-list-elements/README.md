# [203. Remove Linked List Elements][title]

## Problem Description

Remove all elements from a linked list of integers that have value _val_. [here][title]

**Example:**

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```

## Solution

```java
public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val)
        head = head.next;
    
    ListNode prev = null, curr = head;
    while (curr != null) {
        if (curr.val == val) {
            prev.next = curr.next;
        } else
            prev = curr;
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

[title]: https://leetcode.com/problems/remove-linked-list-elements/