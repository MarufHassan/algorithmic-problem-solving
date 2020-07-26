class Solution {
    private int depth(TreeNode x) {
        if (x == null)  return 0;
        return 1 + Math.max(depth(x.left), depth(x.right));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
}