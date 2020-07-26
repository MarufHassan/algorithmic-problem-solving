class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        
        int n = s.length();
        int low = 0, high = 0, maxLen = 0;
        
        while (high < n) {
            if (seen.add(s.charAt(high))) {
                high++;
                maxLen = Math.max(maxLen, high - low);
            } else {
                seen.remove(s.charAt(low));
                low++;
            }
        }
        return maxLen;
    }
}