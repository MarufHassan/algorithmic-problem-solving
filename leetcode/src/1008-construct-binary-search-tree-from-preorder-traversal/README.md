# [1008. Construct Binary Search Tree from Preorder Traversal][title]

## Problem Description

Return the root node of a binary search tree that matches the given preorder traversal.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
```

## Solution

**Approach 1: Recursive**

```java
public TreeNode bstFromPreorder(int[] preorder) {
    return bst(preorder, 0, preorder.length - 1);
}

private TreeNode bst(int[] preorder, int lo, int hi) {
    if (hi < lo)
        return null;
    
    TreeNode x = new TreeNode(preorder[lo]);
    int idx = next(preorder, lo, hi, preorder[lo]);
    
    x.left = bst(preorder, lo + 1, idx - 1);
    x.right = bst(preorder, idx, hi);
    
    return x;
}
```

**Approach 2: Iterative**

```java
// TODO
```

**Definition for a Node**

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

[title]: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/