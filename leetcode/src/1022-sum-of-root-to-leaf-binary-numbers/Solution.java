class Solution {
    private static final int MOD = 1000000007;
    private int sum = 0;
    
    public void sumRootToLeaf(TreeNode root, int n) {
        if (root == null) return;
        n = (n * 2 + root.val) % MOD;
        if (root.left == null && root.right == null) {
            sum = (sum + n)  % MOD;
        }
        sumRootToLeaf(root.left, n);
        sumRootToLeaf(root.right, n);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return sum;
    }
}