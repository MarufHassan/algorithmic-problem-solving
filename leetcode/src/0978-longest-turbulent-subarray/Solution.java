class Solution {
    
    private int compare(int a, int b) {
        return Integer.compare(a, b);
    }
    
    public int maxTurbulenceSize(int[] A) {
        int ans = 1, N = A.length;
        int anchor = 0;
        
        for (int i = 1; i < N; i++) {
            int c1 = compare(A[i - 1], A[i]);
            if (i == N - 1 || c1 * compare(A[i], A[i + 1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }
}