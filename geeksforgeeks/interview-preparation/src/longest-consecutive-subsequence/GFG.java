class GfG
{
    int findLongestConseqSubseq(int a[], int n){
        Arrays.sort(a);
        int longest = 1, count = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] == 0)
                continue;
            if (a[i] - a[i - 1] == 1)
                count++;
            else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }
        return Math.max(longest, count);
    }
}