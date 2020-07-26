# [1022. Sum of Root To Leaf Binary Numbers][title]

## Problem Description

Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers modulo 10^9 + 7.

Detailed description can be found [here][title].

**Example:**

```
Input: [1,0,1,0,1,0,1]
Output: 22

Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

## Solution

```java
public void sumRootToLeaf(TreeNode root, int n) {
    if (root == null) return;
    n = (n * 2 + root.val) % MOD;
    if (root.left == null && root.right == null) {
        sum = (sum + n)  % MOD;
    }
    sumRootToLeaf(root.left, n);
    sumRootToLeaf(root.right, n);
}

public int sumRootToLeaf(TreeNode root) {
    sumRootToLeaf(root, 0);
    return sum;
}
```

**Definition for binary tree node**

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

[title]: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/