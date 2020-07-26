class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (String str : s.split(" ")) {
            str = reverse(str);
            ans.append(str + " ");
        }
        return ans.toString().trim();
    }
    
    private String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = c;
        }
        return new String(chars);
    }
}