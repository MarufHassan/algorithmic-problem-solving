# [103. Binary Tree Zigzag Level Order Traversal][title]

## Problem Description

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Detail instruction can be found [here][title].

**Example:**

```
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
```

## Solution

**Approach 1: BFS**

```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null)   return ans;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    boolean order = true;
    while (!q.isEmpty()) {
        int size = q.size();
        LinkedList<Integer> levels = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode x = q.remove();
            if (order)
                levels.addLast(x.val);
            else
                levels.addFirst(x.val);
            if (x.left  != null)    q.offer(x.left);
            if (x.right != null)    q.offer(x.right);
        }
        ans.add(levels);
        order = !order;
    }
    return ans;
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

[title]: https://leetcode.com/problems/merge-two-binary-trees/