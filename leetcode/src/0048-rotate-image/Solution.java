class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            reverse(matrix, i);
        }
    }
    
    private void reverse(int[][] matrix, int row) {
        int n = matrix.length;
        
        for (int i = 0; i < n / 2; i++) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][n - i - 1];
            matrix[row][n - i - 1] = temp;
        }
    }
}