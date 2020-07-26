# [998. Maximum Binary Tree II][title]

## Problem Description

We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: root = [4,1,3,null,null,2], val = 5
Output: [5,4,null,1,3,null,null,2]

Explanation: A = [1,4,2,3], B = [1,4,2,3,5]
```

**Example 2:**

```
Input: root = [5,2,4,null,1], val = 3
Output: [5,2,4,null,1,null,3]

Explanation: A = [2,1,5,4], B = [2,1,5,4,3]
```

**Example 3:**

```
Input: root = [5,2,3,null,1], val = 4
Output: [5,2,4,null,1,3]

Explanation: A = [2,1,5,3], B = [2,1,5,3,4]
```

## Solution

**Approach 1: O(n^2) time**

```java
public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    List<Integer> nodes = new ArrayList<>();
    inorder(root, nodes);
    nodes.add(val);
    return construct(nodes, 0, nodes.size() - 1);
}

private TreeNode construct(List<Integer> nums, int lo, int hi) {
    if (hi < lo)    return null;
    int max = maxIndex(nums, lo, hi);
    TreeNode root = new TreeNode(nums.get(max));
    root.left = construct(nums, lo, max - 1);
    root.right = construct(nums, max + 1, hi);
    
    return root;
}
```

**private helper methods**

```java
private void inorder(TreeNode root, List<Integer> nodes) {
    if (root == null)   return;
    inorder(root.left, nodes);
    nodes.add(root.val);
    inorder(root.right, nodes);
}

private int maxIndex(List<Integer> nums, int lo, int hi) {
    int max = lo;
    for (int i = lo; i <= hi; i++) {
        if (nums.get(i) > nums.get(max))
            max = i;
    }
    return max;
}
```

**Approach 2: Recursive**

```java
public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    if (root == null)
        return new TreeNode(val);
    if (val > root.val) {
        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }
    root.right = insertIntoMaxTree(root.right, val);
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

[title]: https://leetcode.com/problems/maximum-binary-tree-ii/