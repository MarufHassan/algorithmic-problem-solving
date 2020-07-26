class Solution {    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        
        if (grid[0][0] == 1)    return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        grid[0][0] = 1;
        
        int res = 0;
        
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] curr = q.poll();
                int currX = curr[0], currY = curr[1];
                if (currX == m - 1 && currY == m - 1)
                    return res + 1;
                
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        if (j == 0 && k == 0) continue;
                        int nextX = currX + j;
                        int nextY = currY + k;
                        if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= m || grid[nextX][nextY] == 1)
                            continue;

                        q.add(new int[] {nextX, nextY});
                        grid[nextX][nextY] = 1;
                        
                    }
                }
            }
            res++;
        }
        return -1;
    }
}