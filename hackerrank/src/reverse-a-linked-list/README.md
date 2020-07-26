# [Reverse a linked list][title]

## Problem Description

You’re given the pointer to the head node of a linked list. Change the next pointers of the nodes so that their order is reversed. The head pointer given may be null meaning that the initial list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        5
        1
        2
        3
        4
        5
    Output:
        5 4 3 2 1 
```

## Solution

```java
static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    SinglyLinkedListNode prev = null, curr = head, next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
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

[title]: https://www.hackerrank.com/challenges/reverse-a-linked-list/problem