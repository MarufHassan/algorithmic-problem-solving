class Solution {
    public boolean isArmstrong(int N) {
        int result = 0, n = 0, remainder;
        
        int originalNumber = N;
        while (originalNumber != 0) {
            originalNumber /= 10;
            ++n;
        }
        
        originalNumber = N;
        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }
        return result == N;
    }
}