class Solution {
    public int myAtoi(String str) {
        if (str.length() <= 0)  return 0;
        
        char[] num = str.toCharArray();
        int start = 0;
        
        // ignore leading whitespace
        while (num[start] == ' ') {
            start++;
            if (start >= num.length) // not a number
                return 0;
        }
        
        // sign of the number
        int sign = 1; // default positive
        if (num[start] == '-' || num[start] == '+') { 
            sign = 1 - 2 * (num[start++] == '-' ? 1 : 0);
        }
        
        int number = 0;
        while (start < num.length) {
            if (!isDigit(num[start]))
                break;
            int digit = num[start] - '0';
            //handling overflow test case
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            
            start++;
        }
        
        return number * sign;
    }
    
    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String str = "42";
        assert s.myAtoi(str) == 42;

        str = "-42";
        assert s.myAtoi(str) == -42;

        str = "4193 with words";
        assert s.myAtoi(str) == 4193;

        str = "words and 987";
        assert s.myAtoi(str) == 0;

        str = "-91283472332";
        assert s.myAtoi(str) == Integer.MIN_VALUE;

        str = "           ";
        assert s.myAtoi(str) == 0;
    }
}