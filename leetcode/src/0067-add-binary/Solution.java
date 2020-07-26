class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        
        int carry = 0, s;
        while (i >= 0 || j >= 0 || carry != 0) {
            s = carry;
            s += (i >= 0) ? a.charAt(i) - '0' : 0;
            s += (j >= 0) ? b.charAt(j) - '0' : 0;
            
            ans.append(s % 2);
            carry = s / 2;
            
            i--; j--;
        }
        return ans.reverse().toString();
    }
}