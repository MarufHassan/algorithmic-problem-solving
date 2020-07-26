# [889. Construct Binary Tree from Preorder and Postorder Traversal][title]

## Problem Description

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]

Output: [1,2,3,4,5,6,7]
```

## Solution


```java
public TreeNode constructFromPrePost(int[] pre, int[] post) {
    int n = pre.length;
    if (n == 0)    return null;
    
    for (int i = 0; i < n; i++) {
        index.put(post[i], i);
    }
    
    return construct(pre, post, 0, n - 1, 0);
}

private TreeNode construct(int[] pre, int[] post, int lo, int hi, int pivot) {
    if (hi < lo)    return null;
    if (lo == hi)   return new TreeNode(post[lo]);
    
    TreeNode x = new TreeNode(post[hi]);
    
    int idx = index.get(pre[pivot + 1]);
    
    x.left = construct(pre, post, lo, idx, pivot + 1);
    x.right = construct(pre, post, idx + 1, hi - 1, pivot + (idx - lo + 1) + 1);
    
    return x;
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

[title]: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/