# [508. Most Frequent Subtree Sum][title]

## Problem Description

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

**Example 1:**

```
Input:
  5
 /  \
2   -3

Output:
[2, -3, 4]
```

**Example 2:**

```
Input:
  5
 /  \
2   -5

Output:
[2]
```

## Solution

```java
public int[] findFrequentTreeSum(TreeNode root) {
    traverse(root);
    int[] ans = new int[freq.size()];
    int idx = 0;
    for (int s : freq.keySet()) {
        int val = freq.get(s);
        if (val == most)
            ans[idx++] = s;
    }
    return Arrays.copyOf(ans, idx);
}
```

**private helper methods**

```java
private int traverse(TreeNode root) {
    if (root == null)   return 0;
    
    int left = traverse(root.left);
    int right = traverse(root.right);
    
    int s = root.val + left + right;
    
    freq.put(s, freq.getOrDefault(s, 0) + 1);
    most = Math.max(most, freq.get(s));
    
    return s;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/most-frequent-subtree-sum/