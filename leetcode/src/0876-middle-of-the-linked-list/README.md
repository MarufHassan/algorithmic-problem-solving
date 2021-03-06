# [876. Middle of the Linked List][title]

## Problem Description

Detailed description can be found [here][title]

**Example 1:**

```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])

The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```

**Example 2:**

```
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```

## Solution

**Approach 1:**

```java
public ListNode middleNode(ListNode head) {
    ListNode x = head;
    int n = 0;
    while (x != null) {
        n += 1;
        x = x.next;
    }
    n = n / 2 + 1;
    x = head;
    for (int i = 1; i < n; i++)
        x = x.next;
    return x;
}
```

**Definition for singly-linked list.**

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

**Approach 2:**

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/middle-of-the-linked-list/