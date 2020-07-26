# [653. Two Sum IV - Input is a BST][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

**Example 2:**

```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

## Solution

**Approach 1: In order traversal, two Pointers**

```java
public boolean findTarget(TreeNode root, int target) {
    List<Integer> elems = new ArrayList<>();
    inorder(root, elems);
    
    int lo = 0, hi = elems.size() - 1;
    while (lo < hi) {
        int sum = elems.get(lo) + elems.get(hi);
        if (sum < target) lo++;
        else if (sum > target) hi--; 
        else    return true;
    }
    return false;
}

private void inorder(TreeNode root, List<Integer> elems) {
    if (root == null)  return;
    inorder(root.left, elems);
    elems.add(root.val);
    inorder(root.right,elems);
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

[title]: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/