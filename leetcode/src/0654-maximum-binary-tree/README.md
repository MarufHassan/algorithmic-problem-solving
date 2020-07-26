# [654. Maximum Binary Tree][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
```

## Solution

**Approach 1: Stack**

```java
public TreeNode constructMaximumBinaryTree(int[] nums) {
    Stack<TreeNode> stack = new Stack<>();
    
    TreeNode curr = null;
    for (int i = 0; i < nums.length; i++) {
        curr = new TreeNode(nums[i]);
        while (!stack.isEmpty() && stack.peek().val < nums[i]) {
            curr.left = stack.pop();
        }
        if (!stack.isEmpty())
            stack.peek().right = curr;
        stack.push(curr);
    }
    while (!stack.isEmpty()) {
        curr = stack.pop();
    }
    return curr;
}
```

**Approach 2: Recursive**

```java
public TreeNode constructMaximumBinaryTree(int[] nums) {
    return construct(nums, 0, nums.length - 1);
}

private TreeNode construct(int[] nums, int lo, int hi) {
    if (hi < lo)    return null;
    int max = maxIndex(nums, lo, hi);
    TreeNode root = new TreeNode(nums[max]);
    root.left = construct(nums, lo, max - 1);
    root.right = construct(nums, max + 1, hi);
    
    return root;
}
```

**private helper method**

```java
private int maxIndex(int[] nums, int lo, int hi) {
    int max = lo;
    for (int i = lo; i <= hi; i++) {
        if (nums[i] > nums[max])
            max = i;
    }
    return max;
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

[title]: https://leetcode.com/problems/maximum-binary-tree/