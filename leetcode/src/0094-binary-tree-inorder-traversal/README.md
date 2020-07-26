# [94. Binary Tree Inorder Traversal][title]

## Problem Description

Given a binary tree, return the inorder traversal of its nodes' values.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

## Solution

**Approach 1: Recursive**

```java
private List<Integer> nodes;

public Solution() {
    nodes = new ArrayList<>();
}

public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null)
        return nodes;
    inorderTraversal(root.left);
    nodes.add(root.val);
    inorderTraversal(root.right);
    return nodes;
}
```

**Approach 2: Iterative**

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> nodes = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    
    while (curr != null || !stack.empty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        nodes.add(curr.val);
        curr = curr.right;
    }
    
    return nodes;
}
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

[title]: https://leetcode.com/problems/binary-tree-inorder-traversal/