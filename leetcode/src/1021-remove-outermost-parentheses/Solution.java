class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0, j = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    ans.append(S.substring(j + 1, i));
                    j = i + 1;
                }
            } else {
                stack.push('(');
            }
        }
        
        return ans.toString();
    }
}