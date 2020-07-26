class Solution {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(frequency(s), frequency(t));
    }
    
    private int[] frequency(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}