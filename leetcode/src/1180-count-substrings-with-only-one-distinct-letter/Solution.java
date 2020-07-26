class Solution {
    public int countLetters(String S) {
        int ans = 0;
        
        for (int i = 0; i < S.length(); ) {
            int j = i + 1;
            while (j < S.length() && S.charAt(i) == S.charAt(j)) {
                j++;
            }
            int n = j - i;
            ans += (n * (n + 1) / 2);
            i = j;
        }
        return ans;
    }
}