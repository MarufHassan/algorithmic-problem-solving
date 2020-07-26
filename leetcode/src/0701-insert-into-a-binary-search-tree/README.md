# [701. Insert into a Binary Search Tree][title]

## Problem Description

Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Detail instruction can be found [here][title].

**Example 1:**

```
Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5

         4
       /   \
      2     7
     / \   /
    1   3 5

    This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
```

## Solution

**Approach 1: Recursive**

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null)
        return new TreeNode(val);
    TreeNode find = find(root, val);
    TreeNode node = new TreeNode(val);
    if (val < find.val)
        find.left = node;
    else
        find.right = node;
    return root;
}
```

**private helper method**

```java
private TreeNode find(TreeNode root, int key) {
    if (root.val == key)
        return root;
    else if (root.val > key) {
        if (root.left == null)
            return root;
        return find(root.left, key);
    } else {
        if (root.right == null)
            return root;
        return find(root.right, key);
    }
}
```

**Approach 2: Recursive**

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null)
        return new TreeNode(val);
    
    if      (val < root.val) root.left  =   insertIntoBST(root.left, val);
    else if (val > root.val) root.right =   insertIntoBST(root.right, val);
    
    return root;
}
```

**Approach 3: AVL Balanced Search Tree**

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    List<Integer> values = convert(root, new ArrayList<>());
    
    Node n = balance(values); // make balanced search tree
    n = insert(n, val);   // insert into to the BST
    return convert(n);
}

private Node balance(List<Integer> values) {
    Node root = null;
    for (int val : values) {
        root = insert(root, val);
    }
    return root;
}

private Node insert(Node root, int val) {
    if (root == null)   return new Node(val);
    
    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    } else
        return root;
    root.height = 1 + Math.max(height(root.left), height(root.right));
    return rebalance(root);
}

private Node rebalance(Node node) {
    if (height(node.left) > height(node.right) + 1)
        return rebalanceRight(node);
    if (height(node.right) > height(node.left) + 1)
        return rebalanceLeft(node);
    return node;
}

private Node rebalanceLeft(Node node) {
    if (height(node.right.left) > height(node.right.right))
        node.right = rotateRight(node.right);
    return rotateLeft(node);
}

private Node rebalanceRight(Node node) {
    if (height(node.left.right) > height(node.left.left))
        node.left = rotateLeft(node.left);
    return rotateRight(node);
}

private Node rotateLeft(Node node) {
    Node temp = node.right;
    node.right = temp.left;
    temp.left = node;
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
    return temp;
}

private Node rotateRight(Node node) {
    Node temp = node.left;
    node.left = temp.right;
    temp.right = node;
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
    return temp;
}

private int height(Node x) {
    if (x == null) return 0;
    return x.height;
}

private List<Integer> convert(TreeNode root, List<Integer> values) {
    if (root == null)   return values;
    values.add(root.val);
    
    convert(root.left, values);
    convert(root.right, values);
    
    return values;
}

private TreeNode convert(Node root) {
    if (root == null)   return null;
    TreeNode n = new TreeNode(root.val);
    
    n.left = convert(root.left);
    n.right = convert(root.right);
    
    return n;
}
```

**Approach 4: Iterative**

```java
// TODO
```

**Definition for a AVL Tree Node**

```java
class Node {  // Annotated Node
    Node left, right;
    int val;
    int height;
    
    Node(int x) { val = x; height = 1; }
}
```

**Definition for a Tree Node**

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

[title]: https://leetcode.com/problems/insert-into-a-binary-search-tree/