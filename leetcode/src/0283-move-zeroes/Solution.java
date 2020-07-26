class Solution {
    public void moveZeroes(int[] nums) {
        int tracker = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[tracker++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}