class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        
        for (String word : d) {
            if (isSubsequence(s, word)) {
                if (word.length() > ans.length()) {
                    ans = word;
                } else if (word.length() == ans.length()) {
                    ans = (word.compareTo(ans) < 0) ? word : ans;
                }
            }
        }
        return ans;
    }
    
    private boolean isSubsequence(String text, String word) {
        int j = 0;
        for (int i = 0; i < text.length() && j < word.length(); i++) {
            if (text.charAt(i) == word.charAt(j))
                j++;
        }
        return j == word.length();
    }
}