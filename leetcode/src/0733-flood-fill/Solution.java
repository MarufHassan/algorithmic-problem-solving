class Solution {
    private static final int[] dirX = {+1, 0, -1, 0};
    private static final int[] dirY = {0, +1, 0, -1};
    
    private int nrow, ncol, original, color;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        nrow = image.length; ncol = image[0].length;
        original = image[sr][sc];
        color = newColor;
        
        if (original != color)
            fill(image, sr, sc);
        
        return image;
    }
    
    private void fill(int[][] image, int row, int col) {
        if (row < 0 || row >= nrow || col < 0 || col >= ncol 
            || image[row][col] != original) return;
        
        image[row][col] = color;
        for (int i = 0; i < 4; i++) {
            fill(image, row + dirY[i], col + dirX[i]);
        }
    }
}