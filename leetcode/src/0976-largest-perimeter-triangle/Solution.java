class Solution {
    public int largestPerimeter(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        
        for (int i = n - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if (b + c > a && a + c > b && a +  b > c)
                return a + b + c;
        }
        return 0;
    }
}