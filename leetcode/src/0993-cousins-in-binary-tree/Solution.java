class Solution {
    private int getDepth(TreeNode root, int val, int depth) {
        if (root == null)   return -1;
        if (root.val == val)    return depth;
        
        int left = getDepth(root.left, val, depth + 1);
        return (left == -1) ? getDepth(root.right, val, depth + 1) : left;
    }
    
    private boolean validate(TreeNode root, int x, int y) {
        if (root == null)   return true;
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x)
                return false;
        }
        return validate(root.left, x, y) && validate(root.right, x, y);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        return (getDepth(root, x, 0) == getDepth(root, y, 0)) && validate(root, x, y);
    }
}