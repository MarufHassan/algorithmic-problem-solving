# [129. Sum Root to Leaf Numbers][title]

## Problem Description

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [1,2,3]
    1
   / \
  2   3

Output: 25

Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```
**Example 2:**

```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1

Output: 1026

Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

## Solution

```java
public int sumNumbers(TreeNode root) {
    return sumNumbers(root, 0);
}

private int sumNumbers(TreeNode root, int num) {
    if (root == null)
        return 0;
    int curr = (num * 10 + root.val);
    if (root.left == null && root.right == null)
        return curr;
    int leftsum = sumNumbers(root.left, curr);
    int rightsum = sumNumbers(root.right, curr);
    
    return leftsum + rightsum;
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

[title]: https://leetcode.com/problems/sum-root-to-leaf-numbers/