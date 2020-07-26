# [117. Populating Next Right Pointers in Each Node II][title]

## Problem Description

Detail instruction can be found [here][title].

## Solution

**Approach 1: Iterative BFS**

```java
public Node connect(Node root) {
    if (root == null)   return null;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    Node next, curr;
    while (!q.isEmpty()) {
        int size = q.size();
        next = null;
        for (int i = 0; i < size; i++) {
            curr = q.remove();
            curr.next = next;
            if (curr.right != null)
                q.offer(curr.right);
            if (curr.left != null)
                q.offer(curr.left);
            next = curr;
        }
    }
    return root;
}
```

**Approach 2: Recursive DFS**

```java
// TODO
```

**Definition for a tree node.**

```java
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/