class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int n : data) {
            if (n == 1) ones++;
        }
        if (ones == 0)  return 0;
        
        int[] precompute = new int[data.length];
        if (data[0] == 1)
            precompute[0] = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] == 1) {
                precompute[i] = precompute[i - 1] + 1;
            } else {
                precompute[i] = precompute[i - 1];
            }
        }
        int max = -1, numOfOnes;
        for (int i = ones - 1; i < data.length; i++) {
            if (i == (ones - 1)) {
                numOfOnes = precompute[i];
            } else {
                numOfOnes = precompute[i] - precompute[i - ones];
            }
            max = Math.max(max, numOfOnes);
        }
        return ones - max;
    }
}