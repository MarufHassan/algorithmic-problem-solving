class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i + 1;
            } else {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}