class Solution {
    public boolean queryString(String S, int N) {
        for (int i = N; i >= 1; i--) {
            int idx = S.indexOf(Integer.toBinaryString(i));
            if (idx < 0)    return false;
        }
        return true;
    }
}