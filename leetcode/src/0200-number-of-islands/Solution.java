class Solution {
    private static final int[] dx = {+1, 0, -1, 0};
    private static final int[] dy = {0, +1, 0, -1};
    
    private int R, C;
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0)   return 0;
        
        R = grid.length; C = grid[0].length;
        
        int island = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    island++;
                }
            }
        }
        return island;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= R || col >= C || grid[row][col] != '1')
            return;
        grid[row][col] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dy[i], col + dx[i]);
        }
    }
}