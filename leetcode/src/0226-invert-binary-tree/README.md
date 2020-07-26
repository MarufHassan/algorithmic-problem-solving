# [226. Invert Binary Tree][title]

## Problem Description

Invert a binary tree.

Detail instruction can be found [here][title].

**Example 1:**

```
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

## Solution

**Approach 1: Recursive**

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null)   return null;
    
    root.left = invertTree(root.left);
    root.right = invertTree(root.right);
    
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    return root;
}
```

**Approach 1: Iterative DFS**

```java

// TODO

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

[title]: https://leetcode.com/problems/invert-binary-tree/