class Solution {
    private boolean isAlphaNum(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
    
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            char leftc = Character.toLowerCase(s.charAt(left));
            char rightc = Character.toLowerCase(s.charAt(right));
            
            if (!isAlphaNum(leftc))
                left++;
            else if (!isAlphaNum(rightc)) 
                right--;
            else {
                if (leftc != rightc)
                    return false;
                left++; right--;
            }
        }
        return true;
    }
}