class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftSum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                leftSum = root.left.val;
            else
                leftSum = sumOfLeftLeaves(root.left);
        }
        if (root.right != null)
            leftSum += sumOfLeftLeaves(root.right);
        
        return leftSum;
    }
}