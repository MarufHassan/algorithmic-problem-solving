# [637. Average of Levels in Binary Tree][title]

## Problem Description

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Detail instruction can be found [here][title].

**Example 1:**

```
Input:
    3
   / \
  9  20
    /  \
   15   7

Output: [3, 14.5, 11]

Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
```

## Solution

**Approach 1: Iterative (BFS)**

```java
public List<Double> averageOfLevels(TreeNode root) {
    List<Double> averages = new ArrayList<>();
    if (root == null)
        return averages;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
        int len = q.size();
        double sum = 0;
        for (int i = 0; i < len; i++) {
            TreeNode x = q.poll();
            sum += x.val;
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        averages.add(sum / len);
    }
    return averages;
}
```

**Approach 2: Recursive (DFS)**

```java

// TODO

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

[title]: https://leetcode.com/problems/average-of-levels-in-binary-tree/