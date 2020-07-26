class Solution {
    private static final int[] dx = {+1, 0, -1, 0};
    private static final int[] dy = {0, +1, 0, -1};
    
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dy[i];
                    int nc = c + dx[i];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}