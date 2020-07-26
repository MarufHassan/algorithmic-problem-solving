class Solution {
    private static final int[] dx = {+1, 0, -1, 0};
    private static final int[] dy = {0, +1, 0, -1};
    
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ROTTEN) {
                    q.add(new int[] {r, c});
                }
            }
        }
        
        int minute = 0;
        int[][] distTo = new int[rows][cols];
        
        while (!q.isEmpty()) {
            int[] v = q.poll();
            for (int i = 0; i < 4; i++) {
                int[] w = new int[2];
                w[0] = v[0] + dy[i];
                w[1] = v[1] + dx[i];
                if (w[0] < 0 || w[0] >= rows || w[1] < 0 || w[1] >= cols)
                    continue;
                if (grid[w[0]][w[1]] == FRESH) {
                    q.add(w);
                    grid[w[0]][w[1]] = ROTTEN;
                    distTo[w[0]][w[1]] = distTo[v[0]][v[1]] + 1;
                    minute = distTo[w[0]][w[1]];
                }
            }
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == FRESH) {
                    return -1;
                }
            }
        }
        
        return minute;
    }
}