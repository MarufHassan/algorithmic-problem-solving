# [236. Lowest Common Ancestor of a Binary Tree][title]

## Problem Description

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Detail instruction can be found [here][title].

**Example:**

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
```

## Solution

**Approach 1: Brute Force, O(n^2) time (AC)**

```java
private TreeNode candidate = null;


public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)   return null;
    
    if (contains(root, p) && contains(root, q)) {
        candidate = root;
    }
    
    lowestCommonAncestor(root.left, p, q);
    lowestCommonAncestor(root.right, p, q);
    
    return candidate;
}

private boolean contains(TreeNode x, TreeNode k) {
    if (x == null)  return false;
    if (k.val == x.val)   return true;
    return contains(x.left, k) || contains(x.right, k);
}
```

**Approach 2: Recursive, O(n) time**

```java
private TreeNode candidate = null;

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    traverse(root, p, q);
    return candidate;
}

private boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)   return false;

    int left = traverse(root.left, p, q) ? 1 : 0;
    int right = traverse(root.right, p, q) ? 1 : 0;
    int mid = (root.val == p.val) || (root.val == q.val) ? 1 : 0;
    
    if (left + right + mid >= 2)
        candidate = root;
    return (left + right + mid) > 0;
}
```

**Approach 3: Recursive, Hashing, O(n) time**

```java
Map<TreeNode, TreeNode> parents;

public Solution() {
    parents = new HashMap<>();
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    traverse(root);
    Set<TreeNode> sets = new HashSet<>();
    while (p != null) {
        sets.add(p);
        p = parents.get(p);
    }
    while (!sets.contains(q)) {
        q = parents.get(q);
    }
    return q;
}

private void traverse(TreeNode root) {
    if (root == null)   return;
    if (root.left != null)
        parents.put(root.left, root);
    
    if (root.right != null)
        parents.put(root.right, root);
    
    traverse(root.left);
    traverse(root.right);
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

[title]: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/