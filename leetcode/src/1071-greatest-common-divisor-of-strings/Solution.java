class Solution {
    private int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
    
    private int gcd(int a, int b) {
		if (b == 0)	return a;
		return gcd(b, a % b);
	}
    
    public String gcdOfStrings(String str1, String str2) {
        int lcm = lcm(str1.length(), str2.length());
        int gcd = gcd(str1.length(), str2.length());
        
        for (int i = 0; i < lcm; i++) {
            char c1 = str1.charAt(i % str1.length());
            char c2 = str2.charAt(i % str2.length());
            if (c1 != c2)
                return "";
        }
        
        return str1.substring(0, gcd);
    }
}