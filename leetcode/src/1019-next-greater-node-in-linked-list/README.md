# [1019. Next Greater Node In Linked List][title]

## Problem Description

We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

**Example 1:**

```
Input: [2,1,5]
Output: [5,5,0]
```

**Example 2:**

```
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
```

**Example 3:**

```
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
```

## Solution

**Approach 1: Brute Force (AC)**

```java
public int[] nextLargerNodes(ListNode head) {
    int[] ans = new int[10000];
    int idx = 0;
    
    for (ListNode i = head; i != null; i = i.next, idx++) {
        for (ListNode j = i.next; j != null; j = j.next) {
            if (j.val > i.val) {
                ans[idx] = j.val;
                break;
            }
        }
    }
    return Arrays.copyOf(ans, idx);
}
```

**Approach 2: Stack**

```java
public int[] nextLargerNodes(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> A = new ArrayList<>();
    while (head != null) {
        A.add(head.val);
        head = head.next;
    }
    int[] ans = new int[A.size()];
    for (int i = 0; i < ans.length; i++) {
        while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
            ans[stack.pop()] = A.get(i);
        }
        stack.push(i);
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/next-greater-node-in-linked-list