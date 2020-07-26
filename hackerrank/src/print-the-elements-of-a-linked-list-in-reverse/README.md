# [Print in Reverse][title]

## Problem Description

You are given the pointer to the head node of a linked list and you need to print all its elements in reverse order from tail to head, one element per line. The head pointer may be null meaning that the list is empty - in that case, do not print anything!

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        3
        5
        16
        12
        4
        2
        5
        3
        7
        3
        9
        5
        5
        1
        18
        3
        13
    Output:
        5
        2
        4
        12
        16
        9
        3
        7
        13
        3
        18
        1
        5
```

## Solution

```java
static void reversePrint(SinglyLinkedListNode head) {
    SinglyLinkedListNode prev = null, curr = head, next, x;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    x = prev;
    while (x != null) {
        System.out.println(x.data);
        x = x.next;
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

[title]: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem