class GfG{
    public static ArrayList find3Numbers(int[] a,int n) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = a[i];
            if      (val <= small)  small   = val;
            else if (val < big)     big     = val;
            else if (val > big) {
                ans.addAll(Arrays.asList(small, big, val));
                return ans;
            }
        }
        return ans;
    }
}