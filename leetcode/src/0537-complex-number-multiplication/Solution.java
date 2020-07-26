class Solution {
    public String complexNumberMultiply(String n1, String n2) {
        String[] s1 = n1.split("\\+");
        String[] s2 = n2.split("\\+");
        
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1].substring(0, s1[1].length() - 1));
        int c = Integer.parseInt(s2[0]);
        int d = Integer.parseInt(s2[1].substring(0, s2[1].length() - 1));
        
        int s = a * c + (-1 * b * d);
        int i = a * d + b * c;
        
        return s + "+" + i + "i";
    }
}