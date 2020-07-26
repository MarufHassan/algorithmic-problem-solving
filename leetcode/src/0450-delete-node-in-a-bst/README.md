# [450. Delete Node in a BST][title]

## Problem Description

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1. Search for a node to remove.
2. If the node is found, delete the node.

Note: Time complexity should be O(height of tree).

Detail instruction can be found [here][title].

**Example 1:**

```
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
```

## Solution

**Approach 1: Binary Search Tree**

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)   return null;
    
    if      (key < root.val) root.left  = deleteNode(root.left, key);
    else if (key > root.val) root.right = deleteNode(root.right, key);
    else {
        if (root.left == null)  return root.right;  // no left child
        if (root.right == null) return root.left;   // no right child
        
        // replace with successor
        TreeNode t = root;
        root = min(t.right);
        root.right = deleteNode(t.right, root.val); // delete min
        root.left = t.left;
    }
    return root;
}
```

**private helper methods**

```java
private TreeNode min(TreeNode x) {
    if (x.left == null) return x;
    return min(x.left);
}
```

**Approach 2: AVL Balanced Search Tree**

```java
public TreeNode deleteNode(TreeNode root, int key) {
    List<Integer> values = convert(root, new ArrayList<>());
    
    Node n = balance(values); // make balanced search tree
    n = delete(n, key);
    return convert(n);
}

public Node delete(Node root, int key) {
    if (root == null)   return null;
    
    if      (key < root.val) root.left  = delete(root.left, key);
    else if (key > root.val) root.right = delete(root.right, key);
    else {
        if (root.left == null)  return root.right;  // no left child
        if (root.right == null) return root.left;   // no right child
        
        // replace with successor
        Node t = root;
        root = min(t.right);
        root.right = delete(t.right, root.val); // delete min
        root.left = t.left;
    }
    root.height = 1 + Math.max(height(root.left), height(root.right));
    return rebalance(root);
}

private Node min(Node x) {
    if (x.left == null) return x;
    return min(x.left);
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

**Definition for a AVL tree node.**

```java
class Node {  // Annotated Node
    Node left, right;
    int val;
    int height;
    
    Node(int x) { val = x; height = 1; }
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

[title]: https://leetcode.com/problems/delete-node-in-a-bst/