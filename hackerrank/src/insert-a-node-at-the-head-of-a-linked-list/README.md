# [Insert a node at the head of a linked list][title]

## Problem Description

You’re given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer, insert this node at the head of the linked list and return the new head node. The head pointer given may be null meaning that the initial list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5
        383
        484
        392
        975
        321
    Output:
        321
        975
        392
        484
        383
```

## Solution

```java
static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode head = new SinglyLinkedListNode(data);
    head.next = llist;
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

[title]: https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem