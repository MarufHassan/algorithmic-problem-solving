# [897. Increasing Order Search Tree][title]

## Problem Description

Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Detail instruction can be found [here][title].

**Example:**

```
Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
```

## Solution

**Approach 1: Recursive**

```java
TreeNode curr;

public TreeNode increasingBST(TreeNode root) {
    TreeNode ans = new TreeNode(-1);
    curr = ans;
    inorder(root);
    return ans.right;
}

private void inorder(TreeNode root) {
    if (root == null)   return;
    inorder(root.left);
    curr.right = new TreeNode(root.val);
    curr = curr.right;
    inorder(root.right);
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

[title]: https://leetcode.com/problems/increasing-order-search-tree/