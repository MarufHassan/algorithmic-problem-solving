# [257. Binary Tree Paths][title]

## Problem Description

Given a binary tree, return all root-to-leaf paths.

Detail instruction can be found [here][title].

**Example 1:**

```
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
```

## Solution

**Approach 1: Recursive**

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    dfs(root, "", paths);
    return paths;
}

private void dfs(TreeNode root, String path, List<String> paths) {
    if (root == null)   return;
    if (root.left == null && root.right == null) {
        path += root.val;
        paths.add(path);
    }
    path += (root.val + "->");
    dfs(root.left, path, paths);
    dfs(root.right, path, paths);
}
```

**Approach 2: Iterative**

```java
// TODO
```

**Definition for a Node**

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

[title]: https://leetcode.com/problems/binary-tree-paths/