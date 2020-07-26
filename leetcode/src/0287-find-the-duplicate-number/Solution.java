class Solution {
    private int count(int[] nums, int key) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= key)
                count++;
        }
        return count;
    }
    
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = count(nums, mid);
            
            if (count <= mid)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}