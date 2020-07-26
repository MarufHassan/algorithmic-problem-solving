class Solution {
    private int count(int[] weights, int capacity) {
        int days = 0, c = 0;
        for (int w : weights) {
            c += w;
            if (c > capacity) {
                days++; c = w;
            }
        }
        return days + 1;
    }
    
    public int shipWithinDays(int[] weights, int D) {
        int min = -1, max = 0;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            
            int days = count(weights, mid);
            
            if (days <= D)  max = mid;
            else            min = mid + 1;
        }
        return min;
    }
}