# [Compare two linked lists][title]

## Problem Description

You’re given the pointer to the head nodes of two linked lists. Compare the data in the nodes of the linked lists to check if they are equal. The lists are equal only if they have the same number of nodes and corresponding nodes contain the same data. Either head pointer given may be null meaning that the corresponding list is empty.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        2
        2
        1
        2
        1
        1
        2
        1
        2
        2
        1
        2
    Output:
        0
        1
```

## Solution

```java
static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    while (head1 != null || head2 != null) {
        if (head1 == null || head2 == null)
            return false;
        if (head1.data != head2.data)
            return false;
        head1 = head1.next;
        head2 = head2.next;
    }
    return true;
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

[title]: https://www.hackerrank.com/challenges/compare-two-linked-lists/problem