# [993. Cousins in Binary Tree][title]

## Problem Description

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
```

**Example 2:**

```
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
```

**Example 3:**

```
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
```

## Solution

```java
public boolean isCousins(TreeNode root, int x, int y) {
    return (getDepth(root, x, 0) == getDepth(root, y, 0)) && validate(root, x, y);
}
```

**private helper methods**

```java
private int getDepth(TreeNode root, int val, int depth) {
    if (root == null)   return -1;
    if (root.val == val)    return depth;
    
    int left = getDepth(root.left, val, depth + 1);
    return (left == -1) ? getDepth(root.right, val, depth + 1) : left;
}

private boolean validate(TreeNode root, int x, int y) {
    if (root == null)   return true;
    if (root.left != null && root.right != null) {
        if (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x)
            return false;
    }
    return validate(root.left, x, y) && validate(root.right, x, y);
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

[title]: https://leetcode.com/problems/cousins-in-binary-tree/