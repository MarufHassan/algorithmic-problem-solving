class Solution {
    public int[][] transpose(int[][] A) {
        int[][] t = new int[A[0].length][A.length];
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = A[j][i];
            }
        }
        
        return t;
    }
}