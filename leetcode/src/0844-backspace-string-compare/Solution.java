class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    
    private String build(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#')
                stack.push(c);
            else if (!stack.empty())
                stack.pop();
        }
        return String.valueOf(stack);
    }
}