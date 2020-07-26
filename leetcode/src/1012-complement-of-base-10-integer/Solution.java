class Solution {
    public int bitwiseComplement(int N) {
        if (N <= 0) return 1;
        
        int ans = 0, x = 1;
        
        while (N != 0) {
            if (N % 2 == 0)
                ans += x;
            N /= 2;
            x *= 2;
        }
        
        return ans;
    }
}