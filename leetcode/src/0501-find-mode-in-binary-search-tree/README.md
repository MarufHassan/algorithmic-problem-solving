# [501. Find Mode in Binary Search Tree][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input:
   1
    \
     2
    /
   2
Output: [2]
```

## Solution

**Approach 1:**

```java
private Map<Integer, Integer> freq;
private int max;

public Solution() {
    freq = new HashMap<>();
    max = 0;
}

public int[] findMode(TreeNode root) {
    count(root);
    List<Integer> modes = new ArrayList<>();
    for (int key : freq.keySet()) {
        int val = freq.get(key);
        if (val == max)
            modes.add(key);
    }
    int[] res = new int[modes.size()];
    for (int i = 0; i < res.length; i++)
        res[i] = modes.get(i);
    
    return res;
}
```

**private helper methods**

```java
private void count(TreeNode root) {
    if (root == null) return;
    int val = freq.getOrDefault(root.val, 0);
    max = Math.max(val + 1, max);
    freq.put(root.val, val + 1);
    
    count(root.left);
    count(root.right);
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

[title]: https://leetcode.com/problems/find-mode-in-binary-search-tree/