class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max])
                max = i;
        }
        for (int n : nums) {
            if (n == nums[max]) continue;
            if (n * 2 > nums[max])
                return -1;
        }
        return max;
    }
}