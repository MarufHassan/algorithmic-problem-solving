class Solution {
    public boolean judgeCircle(String moves) {
        int[] map = new int[128];
        map['L'] = -1; map['R'] = +1; map['U'] = +2; map['D'] = -2;
        
        int pos = 0;
        for (char c : moves.toCharArray()) {
            pos += map[c];
        }
        return pos == 0;
    }
}