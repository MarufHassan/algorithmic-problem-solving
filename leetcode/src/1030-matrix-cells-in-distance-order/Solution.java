class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                ans[r * C + c][0] = r;
                ans[r * C + c][1] = c;
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                int d1 = Math.abs(a1[0] - r0) + Math.abs(a1[1] - c0);
                int d2 = Math.abs(a2[0] - r0) + Math.abs(a2[1] - c0);
                return d1 - d2;
            }
        });
        return ans;
    }
}