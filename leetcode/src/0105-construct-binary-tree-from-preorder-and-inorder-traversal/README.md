# [105. Construct Binary Tree from Preorder and Inorder Traversal][title]

## Problem Description

Given preorder and inorder traversal of a tree, construct the binary tree.

Detail instruction can be found [here][title].

**Example 1:**

```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

    3
   / \
  9  20
    /  \
   15   7
```

## Solution

**Approach 1:**

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return construct(preorder, inorder, 0, preorder.length - 1, 0);
}

private TreeNode construct(int[] preorder, int[] inorder, int lo, int hi, int pivot) {
    if (hi < lo)    return null;
    
    int index = search(inorder, lo, hi, preorder[pivot]);
    TreeNode node = new TreeNode(preorder[pivot]);
    
    node.left = construct(preorder, inorder, lo, index - 1, pivot + 1);
    node.right = construct(preorder, inorder, index + 1, hi, pivot + (index - lo + 1));
    
    return node;
}
```

**private helper methods**

```java
private int search(int[] inorder, int lo, int hi, int element) {
    for (int i = lo; i <= hi; i++) {
        if (inorder[i] == element)
            return i;
    }
    return -1;
}
```

**Approach 2: Hash Table**

```java
private Map<Integer, Integer> index;
  
  public Solution() {
      index = new HashMap<>();
  }
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      for (int i = 0; i < inorder.length; i++) {
          index.put(inorder[i], i);
      }
      return construct(preorder, 0, preorder.length - 1, 0);
  }
  
  private TreeNode construct(int[] preorder, int lo, int hi, int pivot) {
      if (hi < lo)    return null;
      
      int idx = index.get(preorder[pivot]);
      TreeNode node = new TreeNode(preorder[pivot]);
      
      node.left = construct(preorder, lo, idx - 1, pivot + 1);
      node.right = construct(preorder, idx + 1, hi, pivot + (idx - lo + 1));
      
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

[title]: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/