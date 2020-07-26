# [700. Search in a Binary Search Tree][title]

## Problem Description

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

Detail instruction can be found [here][title].

**Example 1:**

```
Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

Output:
      2     
     / \   
    1   3
```

## Solution

**Approach 1: Recursive**

```java
public TreeNode searchBST(TreeNode root, int val) {
      if (root == null)
          return null;
      
      if      (val < root.val)    return searchBST(root.left, val);
      else if (val > root.val)    return searchBST(root.right, val);
      else                        return root;
  }
```

**Approach 2: Iterative**

```java
public TreeNode searchBST(TreeNode root, int val) {
      TreeNode x = root;
      while (x != null) {
          if      (x.val == val)  return x;
          else if (val > x.val)   x = x.right;
          else                    x = x.left;
      }
      return x;
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

[title]: https://leetcode.com/problems/search-in-a-binary-search-tree/