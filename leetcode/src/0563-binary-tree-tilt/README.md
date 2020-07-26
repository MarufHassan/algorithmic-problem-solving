# [563. Binary Tree Tilt][title]

## Problem Description

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
         1
       /   \
      2     3

Output: 1

Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
```

## Solution


```java
public int findTilt(TreeNode root) {
    if (root == null)   return 0;
    return Math.abs(sum(root.left) - sum(root.right))
        + findTilt(root.left) + findTilt(root.right);
}
```

**private helper methods**

```java
private int sum(TreeNode x) {
    if (x == null)  return 0;
    return x.val + sum(x.left) + sum(x.right);
}
```

**Definition for a binary tree node.**

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-tree-tilt/