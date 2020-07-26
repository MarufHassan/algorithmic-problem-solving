# [Tree: Height of a Binary Tree][title]

## Problem Description

Detail description can be found [here][title].

## Solution

```java
public static int height(Node root) {
    if (root == null || (root.left == null && root.right == null))
        return 0;
    return Math.max(1 + height(root.left), 1 + height(root.right));
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem