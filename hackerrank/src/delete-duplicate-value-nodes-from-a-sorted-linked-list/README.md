# [Delete duplicate-value nodes from a sorted linked list][title]

## Problem Description

You're given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order. Delete as few nodes as possible so that the list does not contain any value more than once. The given head pointer may be null indicating that the list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        5
        1
        2
        2
        3
        4
    Output:
        1 2 3 4 
```

## Solution

```java
static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    if (head == null)
        return head;
    SinglyLinkedListNode curr = head, next = head.next;
    while (curr != null) {
        while (next != null && curr.data == next.data)
            next = next.next;
        curr.next = next;
        curr = next;
        if (curr != null)
            next = curr.next;
    }
    return head;
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

[title]: https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem