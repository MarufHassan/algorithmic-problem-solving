class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        
        for (int t : time)  remainders[t % 60]++;
        
        int count = 0;
        for (int i = 1; i < 30; i++) {
            int r = 60 - i;
            count += (remainders[i] * remainders[r]);
        }
        count += (remainders[0] * (remainders[0] - 1) / 2);
        count += (remainders[30] * (remainders[30] - 1) / 2);
        
        return count;
    }
}
