class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flip(A[i]);
            invert(A[i]);
        }
        return A;
    }
    
    private void flip(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }
    
    private void invert(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                A[i] = 1;
            else if (A[i] == 1)
                A[i] = 0;
        }
    }
}