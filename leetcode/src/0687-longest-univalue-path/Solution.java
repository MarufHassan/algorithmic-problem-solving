class Solution {
    private int ans;
    
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        find(root);
        return ans;
    }
    
    private int find(TreeNode root) {
        if (root == null) return 0;
        
        int left = find(root.left);
        int right = find(root.right);
        
        int tmpLeft = 0, tmpRight = 0;
        
        if (root.left != null && root.left.val == root.val)
            tmpLeft += (left + 1);
        
        if (root.right != null && root.right.val == root.val)
            tmpRight += (right + 1);
        
        ans = Math.max(ans, tmpLeft + tmpRight);
        
        return Math.max(tmpLeft, tmpRight);
    }
}