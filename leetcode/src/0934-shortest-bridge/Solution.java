class Solution {
    private static final int[] dx = {+1, 0, -1, 0};
    private static final int[] dy = {0, +1, 0, -1};
    
    private int R, C;
    
    public int shortestBridge(int[][] A) {
        R = A.length; C = A[0].length;
        
        dfs(A);
        
        return bfs(A);
    }
    
    private int bfs(int[][] A) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] marked = new boolean[R][C];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 2) {
                    q.add(new int[] {r, c});
                    marked[r][c] = true;
                }
            }
        }
        
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 1; s <= size; s++) {
                int[] v = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nr = v[0] + dy[i];
                    int nc = v[1] + dx[i];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                        continue;
                    if (A[nr][nc] == 1)
                        return distance;
                    if (!marked[nr][nc]) {
                        marked[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    
    private void dfs(int[][] A) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 1) {
                    dfs(A, r, c);
                    return;
                }
            }
        }
    }
    
    private void dfs(int[][] A, int row, int col) {
        if (row < 0 || row >= R || col < 0 || col >= C || A[row][col] != 1)
            return;
        
        A[row][col] += 1;
        for (int i = 0; i < 4; i++) {
            dfs(A, row + dy[i], col + dx[i]);
        }
    }
}