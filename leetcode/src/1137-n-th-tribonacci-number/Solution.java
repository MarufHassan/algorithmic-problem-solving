class Solution {
    public int tribonacci(int n) {
        int[] fibs = new int[40];
        fibs[0] = 0; fibs[1] = 1; fibs[2] = 1;
        
        for (int i = 3; i < 40; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2] + fibs[i - 3];
        }
        return fibs[n];
    }
}