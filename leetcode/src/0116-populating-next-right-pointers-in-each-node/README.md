# [116. Populating Next Right Pointers in Each Node][title]

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

**Approach 2: Recursive, O(n) time, O(1) space**

```java
public Node connect(Node root) {
    populate(root);
    return root;
}

private void populate(Node x) {
    if (x == null)  return;
    if (x.left != null) {
        x.left.next = x.right;
        if (x.next != null)
            x.right.next = x.next.left;
    }
    populate(x.left);
    populate(x.right);
}
```

**Approach 3: Iterative, O(n) time, O(1) space**

```java
public Node connect(Node root) {
    Node start = root, curr;
    while (start != null) {
        curr = start;
        while (curr != null) {
            if (curr.left != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;
            }
            curr = curr.next;
        }
        start = start.left;
    }
    return root;
}
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

[title]: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/