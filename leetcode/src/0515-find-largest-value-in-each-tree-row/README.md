# [515. Find Largest Value in Each Tree Row][title]

## Problem Description

You need to find the largest value in each row of a binary tree.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
```

## Solution

**Approach 1: Iterative BFS**

```java
public List<Integer> largestValues(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null)   return ans;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
        int size = q.size();
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            TreeNode x = q.poll();
            largest = Math.max(largest, x.val);
            if (x.left != null)
                q.offer(x.left);
            if (x.right != null)
                q.offer(x.right);
        }
        ans.add(largest);
    }
    return ans;
}
```

**Approach 2: Recursive DFS**

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

[title]: https://leetcode.com/problems/find-largest-value-in-each-tree-row/