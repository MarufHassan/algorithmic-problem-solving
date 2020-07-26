class Solution {
    private int findMinRotation(int[] A, int[] B, int v) {
        int rotation = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == v) continue;
            if (B[i] == v)
                rotation++;
            else
                return Integer.MAX_VALUE; // large number
        }
        return rotation;
    }
    
    public int minDominoRotations(int[] A, int[] B) {
        int ans = Integer.MAX_VALUE;
        
        ans = Math.min(ans, findMinRotation(A, B, A[0]));
        ans = Math.min(ans, findMinRotation(A, B, B[0]));
        ans = Math.min(ans, findMinRotation(B, A, A[0]));
        ans = Math.min(ans, findMinRotation(B, A, B[0]));

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}