class Solution {
    private int countPath(TreeNode root, int sum) {
        if (root == null)
            return 0;
        
        return ((root.val == sum) ? 1 : 0) +
                countPath(root.left, sum - root.val) 
            +   countPath(root.right, sum - root.val);
    }
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null)   return 0;
        return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}