class Solution {
    private List<String> ans;
    
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, n, "");
        return ans;
    }
    
    private void backtrack(int open, int close, String running) {
        if (open == 0 && close == 0) {
            ans.add(running);
            return;
        }
        if (open > 0) {
            backtrack(open - 1, close, running + "(");
        }
        if (open < close) {
            backtrack(open, close - 1, running + ")");
        }
    }
}