class Solution {
    public String largestTimeFromDigits(int[] A) {
        int[][] perm = new int[][] {
            {A[0], A[1], A[2], A[3]},
            {A[0], A[2], A[1], A[3]},
            {A[0], A[3], A[1], A[2]},
            {A[1], A[2], A[0], A[3]},
            {A[1], A[3], A[0], A[2]},
            {A[2], A[3], A[0], A[1]}
        };
        
        int ans = -1;
        for (int i = 0; i < 6; i++) {
            int hour = best(perm[i][0], perm[i][1], 24);
            int minute = best(perm[i][2], perm[i][3], 60);
            int time = hour * 60 + minute;
            
            if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && time > ans) {
                ans = time;
            }
        }
        
        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
    
    private int best(int d1, int d2, int limit) {
        int n1 = d1 * 10 + d2;
        int n2 = d2 * 10 + d1;
        return Math.max(n1 < limit ? n1 : -1, n2 < limit ? n2 : -1);
    }
}