# [107. Binary Tree Level Order Traversal II][title]

## Problem Description

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

Detail instruction can be found [here][title].

## Solution

**Approach 1: Iterative (BFS)**

```java
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> levels = new LinkedList<>();
    if (root == null)
        return levels;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
        int len = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeNode x = q.poll();
            level.add(x.val);
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        levels.addFirst(level);
    }
    return levels;
}
```

**Approach 2: Recursive (DFS)**

```java
// TODO
```

** Definition for a Node**

```java
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/