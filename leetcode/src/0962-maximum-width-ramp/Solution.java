class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        Integer[] index = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(A[i1], A[i2]);
            }
        });
        
        int nextGreatest = index[n - 1], max = 0;
        for (int i = n - 2; i >= 0; i--) {
            nextGreatest = Math.max(nextGreatest, index[i]);
            max = Math.max(nextGreatest - index[i], max);
        }
        
        return max;
    }
}