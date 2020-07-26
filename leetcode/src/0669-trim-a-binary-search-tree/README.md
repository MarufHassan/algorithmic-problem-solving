# [669. Trim a Binary Search Tree][title]

## Problem Description

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R]  (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Detail instruction can be found [here][title].

**Example:**

```
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
```

## Solution

**Approach 1: Recursive**

```java
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null)   return null;

    if (R < root.val) return trimBST(root.left, L, R);
    if (L > root.val) return trimBST(root.right, L, R);
    
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    
    return root;
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

[title]: https://leetcode.com/problems/trim-a-binary-search-tree/