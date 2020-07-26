# [543. Diameter of Binary Tree][title]

## Problem Description

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Detail instruction can be found [here][title].

**Example:**

```
Input:
          1
         / \
        2   3
       / \     
      4   5    

Output:
    3
```

## Solution

**Approach 1: Recursive**

```java
private int ans;

public int diameterOfBinaryTree(TreeNode root) {
    ans = 0;
    diameter(root);
    return ans;
}

private int diameter(TreeNode root) {
    if (root == null)   return 0;
    
    int left = diameter(root.left);
    int right = diameter(root.right);
            
    ans = Math.max(ans, left + right);
    
    return 1 + Math.max(left, right);
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

[title]: https://leetcode.com/problems/diameter-of-binary-tree/