class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }
        
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            chars[i] = (char) ((idx + shifts[i]) % 26 + 'a');
        }
        return new String(chars);
    }
}