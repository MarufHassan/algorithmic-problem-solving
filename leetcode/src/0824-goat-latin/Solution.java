class Solution {
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    
    public String toGoatLatin(String S) {
        StringBuilder as = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        for (String str : S.split(" ")) {
            if (isVowel(str.charAt(0))) {
                ans.append(str);
            } else {
                ans.append(str.substring(1));
                ans.append(str.charAt(0));
            }
            ans.append("ma");
            as.append('a');
            ans.append(as + " ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}