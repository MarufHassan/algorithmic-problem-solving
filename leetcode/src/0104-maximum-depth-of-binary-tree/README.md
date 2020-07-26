# [104. Maximum Depth of Binary Tree][title]

## Problem Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Detail instruction can be found [here][title].

**Example:**

```
    3
   / \
  9  20
    /  \
   15   7

return 3
```

## Solution

**Approach 1: Recursive**

```java
private int ans;
public int maxDepth(TreeNode root) {
    ans = 0;
    maxDepth(root, 1);
    return ans;
}

private void maxDepth(TreeNode root, int depth) {
    if (root == null)   return;
    ans = Math.max(ans, depth);
    maxDepth(root.left, depth + 1);
    maxDepth(root.right, depth + 1);
}
```

**Approach 2: Recursive**

```java
public int maxDepth(TreeNode root) {
    if (root == null)   return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree/