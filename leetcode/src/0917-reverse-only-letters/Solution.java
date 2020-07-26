class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++; right--;
            }
            if (!Character.isLetter(chars[left]))
                left++;
            if (!Character.isLetter(chars[right]))
                right--;
        }
        return new String(chars);
    }
}