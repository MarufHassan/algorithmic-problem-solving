# [513. Find Bottom Left Tree Value][title]

## Problem Description

Given a binary tree, find the leftmost value in the last row of the tree.

Detail instruction can be found [here][title].

**Example 1:**

```
Input:

    2
   / \
  1   3

Output:
1
```

**Example 2:**

```
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
```

## Solution

```java
public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    TreeNode prev = null, curr;
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            curr = q.remove();
            if (curr.right != null)
                q.offer(curr.right);
            if (curr.left != null)
                q.offer(curr.left);
            prev = curr;
        }
    }
    return prev.val;
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

[title]: https://leetcode.com/problems/find-bottom-left-tree-value/