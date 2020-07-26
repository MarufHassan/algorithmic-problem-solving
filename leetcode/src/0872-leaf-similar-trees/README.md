# [872. Leaf-Similar Trees][title]

## Problem Description

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

Detail instruction can be found [here][title].

## Solution

**Approach 1: Recursive DFS**

```java
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    return dfs(root1).equals(dfs(root2));
}

private List<Integer> dfs(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    dfs(root, values);
    return values;
}
private void dfs(TreeNode root, List<Integer> values) {
    if (root == null)   return;
    if (root.left == null && root.right == null) {
        values.add(root.val);
        return;
    }
    dfs(root.left, values);
    dfs(root.right, values);
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

[title]: https://leetcode.com/problems/leaf-similar-trees/