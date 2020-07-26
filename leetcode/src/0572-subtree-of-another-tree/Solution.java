class Solution {
    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        return (s.val == t.val) && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}