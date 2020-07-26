# [110. Balanced Binary Tree][title]

## Problem Description

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Detail instruction can be found [here][title].

## Solution

**Approach 1: O(n^2) time complexity**

```java
public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    
    if (Math.abs(depth(root.left) - depth(root.right)) > 1)
        return false;
    
    return isBalanced(root.left) && isBalanced(root.right);
}
```

**private helper methods**

```java
private int depth(TreeNode x) {
    if (x == null)  return 0;
    return 1 + Math.max(depth(x.left), depth(x.right));
}
```

**Approach 2: O(n) time, O(1) space**

```java
private int depth(TreeNode x) {
    if (x == null)  return 0;
    
    int leftdepth = depth(x.left);
    int rightdepth = depth(x.right);
    
    if (leftdepth == - 1 || rightdepth == -1)
        return -1;
    if (Math.abs(leftdepth - rightdepth) > 1)
        return -1;
    
    return Math.max(leftdepth, rightdepth) + 1;
}
public boolean isBalanced(TreeNode root) {
    return depth(root) != -1;
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

[title]: https://leetcode.com/problems/balanced-binary-tree/