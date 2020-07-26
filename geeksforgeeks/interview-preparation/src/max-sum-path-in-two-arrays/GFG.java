class GfG {
    int maxPathSum(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0, maxsum = 0;
        int i = 0, j = 0, len1 = arr1.length, len2 = arr2.length;
        
        while (i < len1 && j < len2) {
            if      (arr1[i] < arr2[j]) { sum1 += arr1[i]; i++; }
            else if (arr1[i] > arr2[j]) { sum2 += arr2[j]; j++; }
            else {
                maxsum += Math.max(sum1, sum2);
                maxsum += arr1[i];
                sum1 = 0; sum2 = 0;
                i++; j++;
            }
        }
        while (i < len1)
            sum1 += arr1[i++];
        while (j < len2)
            sum2 += arr2[j++];
        maxsum += Math.max(sum1, sum2);
        
        return maxsum;
    }
}