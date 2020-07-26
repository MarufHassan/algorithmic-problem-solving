# [687. Longest Univalue Path][title]

## Problem Description

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Detail instruction can be found [here][title].

**Example:**

```
Input:
    5
   / \
  4   5
 / \   \
1   1   5

Output:
    2
```

## Solution

**Approach 1: Recursive**

```java
private int ans;

public int longestUnivaluePath(TreeNode root) {
    ans = 0;
    find(root);
    return ans;
}

private int find(TreeNode root) {
    if (root == null) return 0;
    
    int left = find(root.left);
    int right = find(root.right);
    
    int tmpLeft = 0, tmpRight = 0;
    
    if (root.left != null && root.left.val == root.val)
        tmpLeft += (left + 1);
    
    if (root.right != null && root.right.val == root.val)
        tmpRight += (right + 1);
    
    ans = Math.max(ans, tmpLeft + tmpRight);
    
    return Math.max(tmpLeft, tmpRight);
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

[title]: https://leetcode.com/problems/longest-univalue-path/