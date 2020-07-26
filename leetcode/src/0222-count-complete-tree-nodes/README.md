# [222. Count Complete Tree Nodes][title]

## Problem Description

Given a complete binary tree, count the number of nodes.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
```

## Solution

**Approach 1:**

```java
public int countNodes(TreeNode root) {
    if (root == null)  return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

**Approach 2:**

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

[title]: https://leetcode.com/problems/count-complete-tree-nodes/