# [Inserting a Node Into a Sorted Doubly Linked List][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        4
        1
        3
        4
        10
        5
    Output:
        1 3 4 5 10
```

## Solution

```java
static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    if (head == null)
        return new DoublyLinkedListNode(data);
    DoublyLinkedListNode x = head;
    while (x.next != null) {
        if (x.data >= data)
            break;
        x = x.next;
    }
    if (x == head && x.data > data) {
        head = addBefore(x, data);
    } else if (x.data >= data)
        addBefore(x, data);
    else
        addAfter(x, data);
    return head;
}
```

**Helper Method**
```java
static DoublyLinkedListNode addBefore(DoublyLinkedListNode node, int data) {
    DoublyLinkedListNode x = new DoublyLinkedListNode(data);
    x.prev = node.prev;
    x.next = node;
    if (node.prev != null)
        node.prev.next = x;
    node.prev = x;
    return x;
}

static void addAfter(DoublyLinkedListNode node, int data) {
    DoublyLinkedListNode x = new DoublyLinkedListNode(data);
    x.prev = node;
    x.next = node.next;
    if (node.next != null)
        node.next.prev = x;
    node.next = x;
}
```

**Helper class**

```java
DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list