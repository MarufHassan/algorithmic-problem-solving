# [Reverse a doubly linked list][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1
        4
        1
        2
        3
        4
    Output:
        4 3 2 1 
```

## Solution

```java
static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode temp;
    while (head != null) {
        temp = head.next;
        head.next = head.prev;
        head.prev = temp;
        if (head.prev == null)
            break;
        head = head.prev;
    }
    return head;
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

[title]: https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list