# [Delete a Node][title]

## Problem Description

You’re given the pointer to the head node of a linked list and the position of a node to delete. Delete the node at the given position and return the head node. A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The list may become empty after you delete the node.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        8
        20
        6
        2
        19
        7
        4
        15
        9
        3
    Output:
        20 6 2 7 4 15 9
```

## Solution

```java
static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    if (position == 0)
        return head.next;
    SinglyLinkedListNode x = head;
    for (int i = 1; i < position; i++)
        x = x.next;
    x.next = x.next.next;
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

[title]: https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem