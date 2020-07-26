class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3) return false;
        
        int loPtr = 0, hiPtr = A.length - 1;
        while (loPtr < n - 1 && A[loPtr] < A[loPtr + 1])
            loPtr++;
        while (hiPtr > 0 && A[hiPtr - 1] > A[hiPtr])
            hiPtr--;
        return loPtr < n - 1 && hiPtr > 0 && loPtr == hiPtr;
    }
}