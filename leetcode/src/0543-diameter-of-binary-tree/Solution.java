class Solution {
    private int ans;
    
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        diameter(root);
        return ans;
    }
    
    private int diameter(TreeNode root) {
        if (root == null)   return 0;
        
        int left = diameter(root.left);
        int right = diameter(root.right);
                
        ans = Math.max(ans, left + right);
        
        return 1 + Math.max(left, right);
    }
}