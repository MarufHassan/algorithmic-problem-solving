# [Merge two sorted linked lists][title]

## Problem Description

You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which also has data in ascending order. Either head pointer given may be null meaning that the corresponding list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        3
        1
        2
        3
        2
        3
        4
    Output:
        1 2 3 3 4 
```

## Solution

```java
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    if (head1 == null)
        return head2;
    if (head2 == null)
        return head1;
    if (head1.data <= head2.data) {
        head1.next = mergeLists(head1.next, head2);
        return head1;
    } else {
        head2.next = mergeLists(head1, head2.next);
        return head2;
    }
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

[title]: https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem