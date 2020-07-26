# [Cycle Detection][title]

## Problem Description

A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

Complete the function provided for you in your editor. It has one parameter: a pointer to a Node object named `head` that points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.

Detail description can be found [here][title]. 

## Solution

```java
static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null)
        return false;
    SinglyLinkedListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
        if (slow == fast)
            return true;
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
```

**Helper class**

```java
static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem