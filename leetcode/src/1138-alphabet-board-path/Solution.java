class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        
        int r = 0, c = 0;
        int row, col;
        for (char ch : target.toCharArray()) {
            row = (ch - 'a') / 5;
            col = (ch - 'a') % 5;
            
            while (c > col) {
                ans.append('L');
                c--;
            }
            while (r > row) {
                ans.append('U');
                r--;
            }
            while (c < col) {
                ans.append('R');
                c++;
            }

            while (r < row) {
                ans.append('D');
                r++;
            }
            ans.append('!');
            r = row; c = col;
        }
        
        return ans.toString();
    }
}