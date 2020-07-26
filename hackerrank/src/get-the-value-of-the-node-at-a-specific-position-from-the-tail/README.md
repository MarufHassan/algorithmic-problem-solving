# [Get Node Value][title]

## Problem Description

You’re given the pointer to the head node of a linked list and a specific position. Counting backwards from the tail node of the linked list, get the value of the node at the given position. A position of 0 corresponds to the tail, 1 corresponds to the node before the tail and so on.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        2
        1
        1
        0
        3
        3
        2
        1
        2
    Output:
        1
        3
```

## Solution

```java
static int getNode(SinglyLinkedListNode head, int positionFromTail) {
    SinglyLinkedListNode x = head;
    int len = 0;
    while (x != null) {
        len += 1;
        x = x.next;
    }
    x = head;
    for (int i = 1; i < (len - positionFromTail); i++)
        x = x.next;
    return x.data;
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

[title]: https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem