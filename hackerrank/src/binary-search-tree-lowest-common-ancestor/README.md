# [Binary Search Tree : Lowest Common Ancestor][title]

## Problem Description

Detail description can be found [here][title]. 

## Solution

```java
public static Node lca(Node root, int v1, int v2) {
    if (root == null)   return null;
    
    if (v1 < root.data && v2 < root.data)
        return lca(root.left, v1, v2);
    else if (v1 > root.data && v2 > root.data)
        return lca(root.right, v1, v2);
    else
        return root;
}
```

**The Node class is defined as follows:**

```java
class Node {
    int data;
    Node left;
    Node right;
 }
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem