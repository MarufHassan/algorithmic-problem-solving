# [111. Minimum Depth of Binary Tree][title]

## Problem Description

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Detail instruction can be found [here][title].

**Example 1:**

```
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.
```

## Solution

**Approach 1: Recursive (DFS)**

```java
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    if (root.left == null)  return minDepth(root.right) + 1;
    if (root.right == null)  return minDepth(root.left) + 1;
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```

**Approach 2: Iterative BFS**

```java
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    int distance = 1;
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode x = q.poll();
            if (x.left == null && x.right == null)
                return distance;
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        distance += 1;
    }
    return distance;
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

[title]: https://leetcode.com/problems/minimum-depth-of-binary-tree/