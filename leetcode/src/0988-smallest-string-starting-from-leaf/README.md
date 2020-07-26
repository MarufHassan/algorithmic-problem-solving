# [988. Smallest String Starting From Leaf][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [0,1,2,3,4,3,4]
Output: "dba"
```

**Example 2:**

```
Input: [25,1,3,1,3,0,2]
Output: "adz"
```

**Example 3:**

```
Input: [2,2,1,null,1,0,null,0]
Output: "abc"
```

## Solution

```java
private String ans = "";

public String smallestFromLeaf(TreeNode root) {
    traverse(root, "");
    return ans;
}

private void traverse(TreeNode root, String s) {
    if (root == null)   return;
    char c = (char) (root.val + 'a');
    s += c;
    
    if (root.left == null && root.right == null) {
        String rev = reverse(s);
        if (ans == "") ans = rev;
        else if (rev.compareTo(ans) < 0)
            ans = rev;
    }
    traverse(root.left, s);
    traverse(root.right, s);
}
```

**private helper methods**

```java
private String reverse(String s) {
    StringBuilder ans = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
        ans.append(s.charAt(i));
    }
    return ans.toString();
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

[title]: https://leetcode.com/problems/smallest-string-starting-from-leaf/