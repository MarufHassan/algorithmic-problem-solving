# [102. Binary Tree Level Order Traversal][title]

## Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Detail instruction can be found [here][title].

**Example 1:**

```
    3
   / \
  9  20
    /  \
   15   7

[
  [3],
  [9,20],
  [15,7]
]
```

## Solution

**Approach 1: Iterative (BFS)**

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null)
        return levels;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode x = q.poll();
            list.add(x.val);
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        levels.add(list);
    }
    return levels;
}
```

**Approach 2: Recursive (DFS)**

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    levelOrder(root, 0, levels);
    return levels;
}

private void levelOrder(TreeNode root, int level, List<List<Integer>> levels) {
    if (root == null) return;
    List<Integer> values = (level < levels.size()) ? levels.get(level) : new ArrayList<>();
    values.add(root.val);
    if (level == levels.size())
        levels.add(values);
    levelOrder(root.left, level + 1, levels);
    levelOrder(root.right, level + 1, levels);
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

[title]: https://leetcode.com/problems/binary-tree-level-order-traversal/