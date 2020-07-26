# [173. Binary Search Tree Iterator][title]

## Problem Description

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling `next()` will return the next smallest number in the BST.

Detail instruction can be found [here][title].


## Solution

```java
class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stack.pop();
        TreeNode curr = ret.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return ret.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
```

**Definition for a Node**

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-search-tree-iterator/