class Solution {
    public int calculateTime(String keyboard, String word) {
        int curr = 0, time = 0;
        
        for (char c : word.toCharArray()) {
            int pos = keyboard.indexOf(c);
            time += Math.abs(pos - curr);
            curr = pos;
        }
        return time;
    }
}