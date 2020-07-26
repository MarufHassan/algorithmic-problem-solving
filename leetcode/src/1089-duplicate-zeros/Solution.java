class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length, i, j;
        for (i = 0, j = 0; i < n; i++, j++) {
            if (arr[i] == 0) j++;
        }
        for (i = i - 1; i >= 0; i--) {
            if (--j < n)    arr[j] = arr[i];
            
            if (arr[i] == 0 && --j < n)
                arr[j] = 0;
        }
    }
}