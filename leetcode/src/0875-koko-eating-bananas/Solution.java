class Solution {
    private int time(int[] piles, int capacity) {
        int t = 0;
        for (int b : piles) {
            t += (b - 1) / capacity + 1;
        }
        return t;
    }
    
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = 0;
        
        for (int b : piles) {
            hi = Math.max(b, hi);
        }
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int time = time(piles, mid);
            
            if (time <= H)  hi = mid;
            else            lo = mid + 1;
        }
        return lo;
    }
}