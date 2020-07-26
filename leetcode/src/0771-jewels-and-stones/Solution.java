class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] frequency = new int[128];
        int ans = 0;
        
        for (int i = 0; i < S.length(); i++) {
            frequency[S.charAt(i)]++;
        }
        
        for (int i = 0; i < J.length(); i++) {
            ans += frequency[J.charAt(i)];
        }
        
        return ans;
    }
}