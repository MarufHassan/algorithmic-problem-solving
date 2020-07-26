# [Insert a Node at the Tail of a Linked List][title]

## Problem Description

You are given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer. Insert this node at the tail of the linked list and return the head node of the linked list formed after inserting this new node. The given head pointer may be null, meaning that the initial list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5
        141
        302
        164
        530
        474
    Output:
        141
        302
        164
        530
        474
```

## Solution

```java
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    if (head == null)
        return new SinglyLinkedListNode(data);
    SinglyLinkedListNode x = head;
    while (x.next != null) 
        x = x.next;
    x.next = new SinglyLinkedListNode(data);
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

[title]: https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem