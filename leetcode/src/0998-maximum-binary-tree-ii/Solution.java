class Solution {
    TreeNode curr;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(-1);
        curr = ans;
        inorder(root);
        return ans.right;
    }
    
    private void inorder(TreeNode root) {
        if (root == null)   return;
        inorder(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        inorder(root.right);
    }
}