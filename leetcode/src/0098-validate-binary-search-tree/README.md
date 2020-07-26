# [98. Validate Binary Search Tree][title]

## Problem Description

Given a binary tree, determine if it is a valid binary search tree (BST).

Detail instruction can be found [here][title].

**Example 1:**

```
Input:
    2
   / \
  1   3
Output: true
```

**Example 2:**

```
    5
   / \
  1   4
     / \
    3   6
Output: false

Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

## Solution

**Approach 1: O(n^2) time complexity**

```java
public boolean isValidBST(TreeNode root) {
    if (root == null)   return true;
    if (root.left != null && max(root.left) >= root.val)
        return false;
    if (root.right != null && min(root.right) <= root.val)
        return false;
    return isValidBST(root.left) && isValidBST(root.right);
}
```

**private helper methods**

```java
private int max(TreeNode x) {
    if (x == null) return Integer.MIN_VALUE;
    int leftMax = max(x.left);
    int rightMax = max(x.right);
    return Math.max(x.val, Math.max(leftMax, rightMax));
}

private int min(TreeNode x) {
    if (x == null) return Integer.MAX_VALUE;
    int leftMin = min(x.left);
    int rightMin = min(x.right);
    return Math.min(x.val, Math.min(leftMin, rightMin));
}
```

**Approach 2: O(n) time, O(n) space**

```java
private boolean isValidBST(TreeNode root, TreeNode leftLimit, TreeNode rightLimit) {
    if (root == null)   return true;
    
    if (leftLimit != null && root.val <= leftLimit.val)
        return false;
    if (rightLimit != null && root.val >= rightLimit.val)
        return false;
    
    return isValidBST(root.left, leftLimit, root)
        && isValidBST(root.right, root, rightLimit);
}

public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}
```

**Approach 3: O(n) time, O(n) space, in order traversal**

```java
private void traverse(TreeNode root, List<Integer> nodes) {
    if (root == null)   return;
    traverse(root.left, nodes);
    nodes.add(root.val);
    traverse(root.right, nodes);
}

public boolean isValidBST(TreeNode root) {
    List<Integer> nodes = new ArrayList<>();
    traverse(root, nodes);
    
    // check increasing order
    for (int i = 1; i < nodes.size(); i++) {
        if (nodes.get(i) <= nodes.get(i - 1))
            return false;
    }
    return true;
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

[title]: https://leetcode.com/problems/validate-binary-search-tree/