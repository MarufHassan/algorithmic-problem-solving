# [160. Intersection of Two Linked Lists][title]

## Problem Description

Write a program to find the node at which the intersection of two singly linked lists begins.

Detailed description can be found [here][title].

**Example 1:**

```
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8

Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
```

**Example 2:**

```
Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2

Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
```

**Example 3:**

```
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null

Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
```

## Solution

**Approach 1**

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> seen = new HashSet<ListNode>();
    ListNode x = headA;
    while (x != null) {
        seen.add(x);
        x = x.next;
    }
    x = headB;
    while (x != null) {
        if (seen.contains(x))
            return x;
        x = x.next;
    }
    return null;
}
```

**Approach 2:**

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int len1 = len(headA);
    int len2 = len(headB);
    
    int smaller = (len1 < len2) ? len1 : len2;
    headA = move(headA, Math.abs(smaller - len1));
    headB = move(headB, Math.abs(smaller - len2));
    
    while (headA != null && headB != null) {
        if (headA == headB)
            return headA;
        headA = headA.next;
        headB = headB.next;
    }
    return null;
}
```

**Helper Methods**
```java
private ListNode move(ListNode n, int d) {
    while (d-- > 0) {
        n = n.next;
    }
    return n;
}

private int len(ListNode x) {
    int count = 0;
    while (x != null) {
        count++;
        x = x.next;
    }
    return count;
}
```

**Approach 3:**

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
        return null;
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }
    return a;
}
```

**Definition for singly-linked list**

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/intersection-of-two-linked-lists