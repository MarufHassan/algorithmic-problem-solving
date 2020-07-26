class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0, flip = 0;
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] == 0)
                flip++;
            if (flip > K) {
                while (A[j++] == 1);
                flip--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}