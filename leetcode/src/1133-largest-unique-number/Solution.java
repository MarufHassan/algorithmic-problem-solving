class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] count = new int[1001];
        for (int n : A) {
            count[n]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (count[i] == 1)
                return i;
        }
        return -1;
    }
}