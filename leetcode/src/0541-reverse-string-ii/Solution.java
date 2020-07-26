class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i, step = 2 * k;
        
        for (i = 0; i < chars.length; i += step) {
            int start = i, end = Math.min(i + k - 1, chars.length - 1);
            reverse(chars, start, end);
        }
        
        return new String(chars);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char c = chars[start];
            chars[start++] = chars[end];
            chars[end--] = c;
        }
    }
}