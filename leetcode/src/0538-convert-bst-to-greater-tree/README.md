# [538. Convert BST to Greater Tree][title]

## Problem Description

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Detail instruction can be found [here][title].

**Example:**

```
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

## Solution

**Approach 1: Recursive**

```java
private int sum = 0;

public TreeNode convertBST(TreeNode root) {
    if (root == null)   return null;
    
    convertBST(root.right);
    
    sum += root.val;
    root.val = sum;
    
    convertBST(root.left);
    
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

[title]: https://leetcode.com/problems/convert-bst-to-greater-tree/