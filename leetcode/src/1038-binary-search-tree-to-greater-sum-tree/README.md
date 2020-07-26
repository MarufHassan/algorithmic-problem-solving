# [1038. Binary Search Tree to Greater Sum Tree][title]

## Problem Description

Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Detailed description can be found [here][title].

**Example:**

```
Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
```

## Solution

```java
private int sum = 0;

public TreeNode bstToGst(TreeNode root) {
    if (root == null)  return root;
    bstToGst(root.right);
    
    sum += root.val;
    root.val = sum;
    
    bstToGst(root.left);
    
    return root;
}
```

**private node class**

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

[title]: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/