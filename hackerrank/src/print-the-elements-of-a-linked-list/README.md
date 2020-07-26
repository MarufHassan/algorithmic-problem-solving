# [Print the Elements of a Linked List][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        2
        16
        13
    Output:
        16
        13
```

## Solution

```java
static void printLinkedList(SinglyLinkedListNode head) {
    while (head != null) {
        System.out.println(head.data);
        head = head.next;
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

[title]: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list