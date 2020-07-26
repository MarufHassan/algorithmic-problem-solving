class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // negative number can never be palindrome

        // number with last digit zero can never be palindrome except 0.
        if (x % 10 == 0 && x != 0) return false;

        int reverse = 0;
        while (x > reverse) {
        	int pop = x % 10;
            reverse = (reverse * 10) + pop;
            x /= 10;
        }
        return (x == reverse) || (x == reverse / 10) ;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	assert s.isPalindrome(121);
    	assert s.isPalindrome(1232);
    	assert !s.isPalindrome(-121);
    	assert !s.isPalindrome(10);

    	// edge cases
    	assert s.isPalindrome(0);
    	assert s.isPalindrome(00);
    	assert s.isPalindrome(1);
    	assert s.isPalindrome(11);
    	assert s.isPalindrome(22222222);
    	assert !s.isPalindrome(2147483647);
    }
}