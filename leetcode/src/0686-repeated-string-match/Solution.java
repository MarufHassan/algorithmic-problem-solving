class Solution {
    public int repeatedStringMatch(String A, String B) {
        int m = 1;
        StringBuilder S = new StringBuilder(A);
        
        while (S.length() < B.length()) {
            S.append(A);
            m++;
        }
        if (S.indexOf(B) >= 0)
            return m;
        S.append(A);
        if (S.indexOf(B) >= 0)
            return m + 1;
        return -1;
    }
}