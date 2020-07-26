# [106. Construct Binary Tree from Inorder and Postorder Traversal][title]

## Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

Detail instruction can be found [here][title].

**Example 1:**

```
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

    3
   / \
  9  20
    /  \
   15   7
```

## Solution


```java
private Map<Integer, Integer> index;

public Solution() {
    index = new HashMap<>();
}

public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
        index.put(inorder[i], i);
    }
    return construct(postorder, 0, postorder.length - 1, postorder.length - 1);
}

private TreeNode construct(int[] postorder, int lo, int hi, int pivot) {
    if (hi < lo)    return null;
    
    int idx = index.get(postorder[pivot]);
    TreeNode node = new TreeNode(postorder[pivot]);
    
    node.right = construct(postorder, idx + 1, hi, pivot - 1);
    node.left = construct(postorder, lo, idx - 1,  pivot - (hi - idx + 1));
    
    return node;
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

[title]: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/