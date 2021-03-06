# [437. Path Sum III][title]

## Problem Description

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Detail instruction can be found [here][title].

**Example 1:**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

## Solution

**Approach 1:**

```java
public int pathSum(TreeNode root, int sum) {
      if (root == null)   return 0;
      return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }
```

**private helper methods**

```java
private int countPath(TreeNode root, int sum) {
    if (root == null)
        return 0;
    
    return ((root.val == sum) ? 1 : 0) +
            countPath(root.left, sum - root.val) 
        +   countPath(root.right, sum - root.val);
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

[title]: https://leetcode.com/problems/path-sum-iii/