# [114. Flatten Binary Tree to Linked List][title]

## Problem Description

Given a binary tree, flatten it to a linked list in-place.

Detail instruction can be found [here][title].

**Example:**

```
Input:
    1
   / \
  2   5
 / \   \
3   4   6

Output:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

## Solution

```java
private List<TreeNode> nodes;

public Solution() {
    nodes = new ArrayList<>();
}

public void flatten(TreeNode root) {
    traverse(root);
    TreeNode x = root;
    for (int i = 1; i < nodes.size(); i++) {
        x.right = nodes.get(i);
        x.left = null;
        x = x.right;
    }
}
```

**private helper methods**

```java
private void traverse(TreeNode root) {
    if (root == null)   return;
    nodes.add(root);
    traverse(root.left);
    traverse(root.right);
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

[title]: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/