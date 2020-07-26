# [113. Path Sum II][title]

## Problem Description

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Detail instruction can be found [here][title].

**Example 1:**

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
```

## Solution


```java
private List<List<Integer>> sums;

public Solution() {
    sums = new ArrayList<>();
}

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    dfs(root, sum, new Stack<>());
    return sums;
}
```

**private helper methods**

```java
private void dfs(TreeNode root, int sum, Stack<Integer> path) {
    if (root == null)   return;
    path.push(root.val);
    
    if (root.left == null && root.right == null && root.val == sum){
        sums.add(new ArrayList<>(path));
    }
    
    dfs(root.left, sum - root.val, path);
    dfs(root.right, sum - root.val, path);
    path.pop();
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

[title]: https://leetcode.com/problems/path-sum-ii/