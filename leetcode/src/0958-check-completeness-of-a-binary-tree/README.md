# [958. Check Completeness of a Binary Tree][title]

## Problem Description

Given a binary tree, determine if it is a complete binary tree.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [1,2,3,4,5,6]
Output: true

Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
```

## Solution

**Approach 1: Level order traversal**

```java
public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    
    q.offer(root);
    boolean isNull = false;
    
    while (!q.isEmpty()) {
        TreeNode curr = q.poll();
        if (curr == null) isNull = true;
        else {
            if (isNull) return false;
            q.offer(curr.left);
            q.offer(curr.right);
        }
    }
    return true;
}
```

**Approach 2: Level order traversal**

```java
public boolean isCompleteTree(TreeNode root) {
    if (root == null)  return true;
    
    Queue<Node> q = new LinkedList<>();
    List<Integer> store = new ArrayList<>();
    
    q.offer(new Node(root, 1));
    while (!q.isEmpty()) {
        int size=  q.size();
        
        for (int i = 0; i < size; i++) {
            Node x = q.poll();
            store.add(x.code);

            if (x.node.left != null)
                q.offer(new Node(x.node.left, 2 * x.code));
            if (x.node.right != null)
                q.offer(new Node(x.node.right, 2 * x.code + 1));
        }
    }
    return store.get(store.size() - 1) == store.size();
}
```

**annotated node**

```java
class Node {
    TreeNode node;
    int code;
    public Node(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}
```

**Definition for a binary tree node.**

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

[title]: https://leetcode.com/problems/check-completeness-of-a-binary-tree/submissions/