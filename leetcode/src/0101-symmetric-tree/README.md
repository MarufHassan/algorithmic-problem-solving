# [101. Symmetric Tree][title]

## Problem Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Detail instruction can be found [here][title].

**Example:**

```
this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
```

## Solution

**Approach 1: Recursive**

```java
public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

private boolean isMirror(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)  return true;
    if (node1 == null || node2 == null)  return false;
    
    return node1.val == node2.val && 
            isMirror(node1.right, node2.left) 
        &&  isMirror(node1.left, node2.right);
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

[title]: https://leetcode.com/problems/symmetric-tree/