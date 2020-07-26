# [Is This a Binary Search Tree?][title]

## Problem Description

Detail description can be found [here][title]. 

## Solution

```java
boolean checkBST(Node root) {
    return checkBST(root, null, null);
}

boolean checkBST(Node x, Node lower, Node upper) {
    if (x == null) return true;
    
    if (upper != null && x.data >= upper.data) // check validity of left subtree
        return false;
    
    if (lower != null && x.data <= lower.data) // check validity of right subtree
        return false;
    
    return checkBST(x.left, lower, x)
        && checkBST(x.right, x, upper);
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

[title]: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem