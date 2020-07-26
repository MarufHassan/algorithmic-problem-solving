class Solution {
    public int mySqrt(int x) {
        long lo = 1, hi = x;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            
            if (mid * mid <= x)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return (int) (lo * lo <= x ? lo : lo - 1);
    }
}