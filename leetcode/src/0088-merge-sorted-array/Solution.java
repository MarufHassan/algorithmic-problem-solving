class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        
        int[] aux = new int[m + n];
        
        for (int k = 0; k < m + n; ) {
            if      (i >= m) aux[k++] = nums2[j++];
            else if (j >= n) aux[k++] = nums1[i++];
            else if (nums1[i] > nums2[j]) aux[k++] = nums2[j++];
            else    aux[k++] = nums1[i++];
        }
        System.arraycopy(aux, 0, nums1, 0, m + n);
    }
}