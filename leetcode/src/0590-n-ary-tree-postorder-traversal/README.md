# [590. N-ary Tree Postorder Traversal][title]

## Problem Description

Given an n-ary tree, return the postorder traversal of its nodes' values.

Detail instruction can be found [here][title].

## Solution

**Approach 1: Recursive**

```java
private List<Integer> nodes;

public Solution() {
    nodes = new ArrayList<>();
}

public List<Integer> postorder(Node root) {
    if (root == null)
        return nodes;
    for (Node desc : root.children) {
        postorder(desc);
    }
    nodes.add(root.val);
    return nodes;
}
```

**Approach 2: Iterative**

```java
private List<Integer> nodes;

public Solution() {
    nodes = new ArrayList<>();
}

public List<Integer> postorder(Node root) {
    if (root == null)
        return nodes;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.empty()) {
        Node x = stack.pop();
        nodes.add(x.val);
        for (Node desc : x.children) {
            stack.push(desc);
        }
    }
    Collections.reverse(nodes);
    return nodes;
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