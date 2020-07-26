class Solution {
    
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookCol = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == 'R') {
                    rookRow = row;
                    rookCol = col;
                    break;
                }
            }
        }
        
        int pawns = 0;
        
        for (int i = 0; i < 4; i++) {
            int newRow = rookRow + dirs[i][0];
            int newCol = rookCol + dirs[i][1];
            while (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                if (board[newRow][newCol] == 'B')
                    break;
                if (board[newRow][newCol] == 'p') {
                    pawns++;
                    break;
                }
                
                newRow += dirs[i][0];
                newCol += dirs[i][1];
            }
        }
        
        return pawns;
    }
}