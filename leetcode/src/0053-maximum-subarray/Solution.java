class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;
        int n = nums.length;
        
        int prev = nums[0], curr;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            curr = Math.max(nums[i] + prev, nums[i]);
            max = Math.max(curr, max);
            prev = curr;
        }
        return max;
    }
}