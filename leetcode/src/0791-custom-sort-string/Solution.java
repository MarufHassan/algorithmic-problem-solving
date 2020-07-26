class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        StringBuilder ans = new StringBuilder();
        
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) ans.append(c);
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) ans.append(c);
        }
        
        return ans.toString();
    }
}