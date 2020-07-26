# [572. Subtree of Another Tree][title]

## Problem Description

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Detail instruction can be found [here][title].

**Example 1:**

```
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
```

**Example 2:**

```
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
```

## Solution

**Approach 1: Recursive**

```java
private boolean isIdentical(TreeNode s, TreeNode t) {
    if (s == null && t == null)
        return true;
    if (s == null || t == null)
        return false;
    
    return (s.val == t.val) && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
}
public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
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

[title]: https://leetcode.com/problems/subtree-of-another-tree/