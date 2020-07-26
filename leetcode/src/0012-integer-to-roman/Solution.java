class Solution {
	private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
       									  50,   40,   10,    9,    5,    4,    1 };

    private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                       	"L",  "XL",  "X",  "IX", "V",  "IV", "I" };

	public String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();  // The roman numeral.
		
        for (int i = 0; i < numbers.length; i++) {
           while (num >= numbers[i]) {
              roman.append(letters[i]);
              num -= numbers[i];
           }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 3;
        assert s.intToRoman(n).equals("III");

        n = 4;
        assert s.intToRoman(n).equals("IV");

        n = 9;
        assert s.intToRoman(n).equals("IX");

        n = 58;
        assert s.intToRoman(n).equals("LVIII");

        n = 1994;
        assert s.intToRoman(n).equals("MCMXCIV");

        n = 3999;
        assert s.intToRoman(n).equals("MMMCMXCIX");
    }
}