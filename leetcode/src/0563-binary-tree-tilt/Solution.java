class Solution {
    public int findTilt(TreeNode root) {
        if (root == null)   return 0;
        return Math.abs(sum(root.left) - sum(root.right))
            + findTilt(root.left) + findTilt(root.right);
    }
    
    private int sum(TreeNode x) {
        if (x == null)  return 0;
        return x.val + sum(x.left) + sum(x.right);
    }
}