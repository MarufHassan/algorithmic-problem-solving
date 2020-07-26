# [589. N-ary Tree Preorder Traversal][title]

## Problem Description

Given an n-ary tree, return the preorder traversal of its nodes' values.

Detail instruction can be found [here][title].

## Solution

**Approach 1: Recursive**

```java
public List<Integer> preorder(Node root) {
    List<Integer> nodes = new ArrayList<>();
    traverse(root, nodes);
    return nodes;
}

private void traverse(Node x, List<Integer> nodes) {
    if (x == null)  return;
    nodes.add(x.val);
    for (Node descendent : x.children) {
        traverse(descendent, nodes);
    }
}
```

**Approach 2: Iterative**

```java
public List<Integer> preorder(Node root) {        
    List<Integer> nodes = new ArrayList<>();
    if (root == null) return nodes;
    
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.empty()) {
        Node x = stack.pop();            
        nodes.add(x.val);
        List<Node> children = x.children;
        for (int i = children.size() - 1; i >= 0; i--) {
            stack.push(children.get(i));
        }
    }
    
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

[title]: https://leetcode.com/problems/n-ary-tree-preorder-traversal