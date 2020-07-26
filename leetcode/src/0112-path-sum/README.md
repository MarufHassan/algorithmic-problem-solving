# [700. Search in a Binary Search Tree][title]

## Problem Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Detail instruction can be found [here][title].

**Example 1:**

```
Given the tree:
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

And the value to search: 2

Output:
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
```

## Solution

**Approach 1: Recursive**

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
        return false;
    if (root.left == null && root.right == null && sum - root.val == 0)
        return true;
    return  hasPathSum(root.left, sum - root.val)
        ||  hasPathSum(root.right, sum - root.val);
}
```

**Approach 2: Iterative**

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

[title]: https://leetcode.com/problems/path-sum/