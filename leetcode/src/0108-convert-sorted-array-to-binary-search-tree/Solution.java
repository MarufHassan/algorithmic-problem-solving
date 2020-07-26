class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0)   return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        
        int mid = lo + (hi - lo) / 2;
        TreeNode x = new TreeNode(nums[mid]);
        x.left = sortedArrayToBST(nums, lo, mid - 1);
        x.right = sortedArrayToBST(nums, mid + 1, hi);
        
        return x;
    }
}