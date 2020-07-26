# [Linked Lists: Detect a Cycle][title]

## Problem Description

Detail description can be found [here][title]. 


## Solution

```java
boolean hasCycle(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        if (slow == fast.next)
            return true;
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
```

**Helper Class**

```java
class Node {
    int data;
    Node next;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/ctci-linked-list-cycle/