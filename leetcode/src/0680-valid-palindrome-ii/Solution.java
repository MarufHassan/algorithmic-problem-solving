class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        if (isPalindrome(s, left, right))
            return true;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left++; right--;
        }
        
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}