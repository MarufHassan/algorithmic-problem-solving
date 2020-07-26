class Solution {
    private List<String> ans = new ArrayList<>();
    
    public List<String> letterCasePermutation(String S) {
        permute(S.toCharArray(), 0);
        return ans;
    }
    
    private void permute(char[] str, int i) {
        if (i == str.length) {
            ans.add(String.valueOf(str)); return;
        }
        
        if (Character.isLetter(str[i])) {
            str[i] = Character.toLowerCase(str[i]);
            permute(str, i + 1);
            str[i] = Character.toUpperCase(str[i]);
        }
        permute(str, i + 1);
    }
}