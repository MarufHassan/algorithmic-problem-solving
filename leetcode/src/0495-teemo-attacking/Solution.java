class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0, end = 0;
        
        for (int start : timeSeries) {
            if (start < end) {
                total += (start + duration - end);
            } else {
                total += duration;
            }
            end =  start + duration;
        }
        
        return total;
    }
}