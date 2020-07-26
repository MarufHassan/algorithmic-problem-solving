# [559. Maximum Depth of N-ary Tree][title]

## Problem Description

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

Detail instruction can be found [here][title].

## Solution

**Approach 1: Recursive**

```java
public int maxDepth(Node root) {
    if (root == null)
        return 0;
    int maxDepth = 1;
    for (Node x : root.children) {
        maxDepth = Math.max(maxDepth, 1 + maxDepth(x));
    }
    return maxDepth;
}
```

**Approach 2: Iterative (BFS)**

```java
public int maxDepth(Node root) {
    if (root == null)
        return 0;
    int maxDepth = 0;
    Queue<Node> q =  new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            Node x = q.poll();
            for (Node desc : x.children) {
                q.offer(desc);
            } 
        }
        maxDepth += 1;
    }
    return maxDepth;
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

[title]: https://leetcode.com/problems/n-ary-tree-postorder-traversal/