class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int evensum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                evensum += A[i];
        }
        
        for (int i = 0; i < n; i++) {
            int index = queries[i][1];
            int value = queries[i][0];
            if ((A[index] + value) % 2 == 0) {
                evensum += value;
                if (A[index] % 2 != 0)
                    evensum += A[index];
            } else {
                if (A[index] % 2 == 0)
                    evensum -= A[index];
            }
            A[index] += value;
            ans[i] = evensum;
        }
        return ans;
    }
}