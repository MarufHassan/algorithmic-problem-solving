class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1, -1};
        if (n == 0) return ans;
        
        // lower bound binary search
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (target < nums[mid])        hi = mid - 1;
            else if (target > nums[mid])        lo = mid + 1;
            else {
                ans[0] = mid;   // first position
                hi = mid - 1;
            }
        }
        
        // upper bound binary search
        lo = 0; hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (target < nums[mid])        hi = mid - 1;
            else if (target > nums[mid])        lo = mid + 1;
            else {
                ans[1] = mid; // last position
                lo = mid + 1;
            }
        }
        
        return ans;
    }
}