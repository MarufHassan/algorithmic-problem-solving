class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                String shifted = shiftLeft(s, i);
                if (shifted.equals(s))
                    return true;
            }
        }
        return false;
    }
    
    private String shiftLeft(String s, int len) {
        String ret = s.substring(len);
        ret += s.substring(0, len);
        return ret;
    }
}