class Solution {
    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0)   return ans;
        generate(digits, 0, "");
        return ans;
    }
    
    private void generate(String digits, int offset, String prefix) {
        if (offset >= digits.length()) {
            ans.add(prefix);
            return;
        }
        
        String letters = map[digits.charAt(offset) - '0'];
        for (int j = 0; j < letters.length(); j++) {
            generate(digits, offset + 1, prefix + letters.charAt(j));
        }
    }
}