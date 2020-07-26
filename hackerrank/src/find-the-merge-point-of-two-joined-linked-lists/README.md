# [Reverse a doubly linked list][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        1
        3
        1
        2
        3
        1
        1
    Output:
        2 
```

**Example 2:**

```
    Input: 
        1
        2
        3
        1
        2
        3
        1
        1
    Output:
        3
```

## Solution

```java
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode a = head1, b = head2;
    while (a != b) {
        a = (a == null) ? head2 : a.next;
        b = (b == null) ? head1 : b.next;
    }
    return a.data;
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

[title]: https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists