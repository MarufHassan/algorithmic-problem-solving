class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        
        for (int i = 1; i <= 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'L') {
                    dir = (dir + 1) % 4;
                } else if (c == 'R') {
                    dir = (dir + 3) % 4;
                } else {
                    x += d[dir][0];
                    y += d[dir][1];
                }
            }
        }
        return x == 0 && y == 0;
    }
}