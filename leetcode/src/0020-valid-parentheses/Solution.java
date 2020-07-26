class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] table = new char[128];
        table[')'] = '('; table['}'] = '{'; table[']'] = '[';

        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && table[c] == stack.peek())
                stack.pop();
            else 
                stack.push(c);
        }
        return stack.isEmpty();
    }
}