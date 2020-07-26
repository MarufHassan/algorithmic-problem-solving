# [623. Add One Row to Tree][title]

## Problem Description

Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   
```

**Example 2:**

```
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
```

## Solution

**Approach 1: Iterative BFS**

```java
public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
        TreeNode node = new TreeNode(v);
        node.left = root;
        return node;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int level = 1;
    while (level < d - 1) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode x = q.poll();
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        level += 1;
    }
    while (!q.isEmpty()) {
        TreeNode x = q.poll();
        TreeNode left = x.left;
        TreeNode right = x.right;
        x.left = new TreeNode(v);
        x.left.left = left;
        x.right = new TreeNode(v);
        x.right.right = right;
    }        
    return root;
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

[title]: https://leetcode.com/problems/add-one-row-to-tree/