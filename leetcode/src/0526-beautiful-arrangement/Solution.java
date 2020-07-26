class Solution {
    private int count;
    
    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
        count = 0;
        permute(nums, 1);
        
        return count;
    }
    
    private void permute(int[] nums, int offset) {
        if (offset >= nums.length) {
            count++; return;
        }
        
        for (int i = offset; i < nums.length; i++) {
            swap(nums, i, offset);
            if (nums[offset] % offset == 0 || offset % nums[offset] == 0)
                permute(nums, offset + 1);
            swap(nums, i, offset);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}