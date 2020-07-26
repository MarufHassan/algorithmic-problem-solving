# [108. Convert Sorted Array to Binary Search Tree][title]

## Problem Description

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Detail instruction can be found [here][title].

**Example 1:**

```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

## Solution

**Approach 1:**

```java
public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length <= 0)   return null;
    return sortedArrayToBST(nums, 0, nums.length - 1);
}
```

**private helper methods**

```java
private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
    if (lo > hi)
        return null;
    
    int mid = lo + (hi - lo) / 2;
    TreeNode x = new TreeNode(nums[mid]);
    x.left = sortedArrayToBST(nums, lo, mid - 1);
    x.right = sortedArrayToBST(nums, mid + 1, hi);
    
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

[title]: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/