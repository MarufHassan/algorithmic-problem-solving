# [429. N-ary Tree Level Order Traversal][title]

## Problem Description

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Detail instruction can be found [here][title].

## Solution

**Approach 1: Iterative (BFS)**

```java
public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null)
        return levels;
    Queue<Node> que = new LinkedList<>();
    que.offer(root);
    
    while (!que.isEmpty()) {
        List<Integer> level = new ArrayList<>();
        int size = que.size();
        for (int i = 0; i < size; i++) {
            Node x = que.poll();
            level.add(x.val);
            for (Node desc : x.children) {
                que.add(desc);
            }
        }
        levels.add(level);
    }
    return levels;
}
```

**Approach 2: Recursive (DFS)**

```java
public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> levels = new ArrayList<>();
    levelOrder(root, 0, levels);
    return levels;
}

private void levelOrder(Node x, int level, List<List<Integer>> levels) {
    if (x == null)  return;
    
    List<Integer> list = (level < levels.size()) ? levels.get(level) : new ArrayList<>();
    list.add(x.val);
    if (level == levels.size())
        levels.add(list);
    for (Node desc : x.children) {
        levelOrder(desc, level + 1, levels);
    }
}
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

[title]: https://leetcode.com/problems/n-ary-tree-level-order-traversal/