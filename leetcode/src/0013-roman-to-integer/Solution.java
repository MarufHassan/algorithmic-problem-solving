import java.util.*;

class Solution {
    public int romanToInt(String s) {
    	if (s.length() <= 0)
    		return 0;

    	int[] map = new int[26];
	    map['I' - 'A'] = 1;
	    map['V' - 'A'] = 5;
	    map['X' - 'A'] = 10;
	    map['L' - 'A'] = 50;
	    map['C' - 'A'] = 100;
	    map['D' - 'A'] = 500;
	    map['M' - 'A'] = 1000;
        
        int c = s.charAt(s.length() - 1) - 'A';
        int result = map[c];

        for (int i = s.length() - 2; i >= 0; i--) {
        	c = s.charAt(i) - 'A';
        	int value = map[c];

        	c = s.charAt(i + 1) - 'A';

        	if (value < map[c])
        		result -= value;
        	else
        		result += value;

        }
        return result;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();

    	String str = "III";
    	assert s.romanToInt(str) == 3;

    	str = "IV";
    	assert s.romanToInt(str) == 4;

    	str = "VIII";
    	assert s.romanToInt(str) == 8;

    	str = "LVIII";
    	assert s.romanToInt(str) == 58;

    	str = "MCMXCIV";
    	assert s.romanToInt(str) == 1994;

    	str = "";
    	assert s.romanToInt(str) == 0;

    	str = "MMMCMXCIX";
    	assert s.romanToInt(str) == 3999;
    }
}