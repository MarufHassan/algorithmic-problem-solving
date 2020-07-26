class Solution {
    private static final int[] directionX = {+1, 0, -1, 0};
    private static final int[] directionY = {0, +1, 0, -1};
    
    private int count;
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                count = 0;
                if (grid[r][c] == 1)
                    dfs(grid, r, c);
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return;
        
        count += 1;
        grid[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + directionY[i];
            int newCol = col + directionX[i];
            dfs(grid, newRow, newCol);
        }
    }
}