# [Insert a node at a specific position in a linked list][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        3
        16
        13
        7
        1
        2
    Output:
        16 13 1 7
```

## Solution

```java
static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode x = head;
    if (position == 0) {
        x = new SinglyLinkedListNode(data);
        x.next = head;
        head = x;
        return head;
    }
    
    while (--position > 0)
        x = x.next;
    addAfter(x, data);
    return head;
}
```

**Helper Method**

```java
static void addAfter(SinglyLinkedListNode node, int data) {
    SinglyLinkedListNode x = new SinglyLinkedListNode(data);
    x.next = node.next;
    node.next = x;
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

[title]: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list