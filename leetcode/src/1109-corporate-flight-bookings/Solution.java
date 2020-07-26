class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int lo, hi, val;
        for (int[] booking : bookings) {
            lo = booking[0] - 1; hi = booking[1] - 1;
            val = booking[2];
            
            ans[lo] += val;
            if (hi != n - 1)
                ans[hi + 1] -= val;
        }
        
        for (int i = 1; i < n; i++) 
            ans[i] += ans[i - 1]; 
        return ans;
    }
}