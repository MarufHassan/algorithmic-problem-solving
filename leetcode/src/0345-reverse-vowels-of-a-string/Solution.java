class Solution {
    public boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int lo = 0, hi = s.length() - 1;
        
        while (lo < hi) {
            if (isVowel(chars[lo]) && isVowel(chars[hi])) {
                char t = chars[lo];
                chars[lo] = chars[hi];
                chars[hi] = t;
                lo++; hi--;
            }
            if (!isVowel(chars[lo]))
                lo++;
            if (!isVowel(chars[hi]))
                hi--;
        }
        return new String(chars);
    }
}