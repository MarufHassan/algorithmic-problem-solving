class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (!stack.empty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.size();
    }
}