class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int num) {
        if (root == null)
            return 0;
        int curr = (num * 10 + root.val);
        if (root.left == null && root.right == null)
            return curr;
        int leftsum = sumNumbers(root.left, curr);
        int rightsum = sumNumbers(root.right, curr);
        
        return leftsum + rightsum;
    }
}