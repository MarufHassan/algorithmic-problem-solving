class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            char c = token.charAt(token.length() - 1);
            
            if (Character.isDigit(c)) {
                int num = Integer.parseInt(token);
                stack.push(num);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (c == '+')       stack.push(num2 + num1);
                else if (c == '-')  stack.push(num2 - num1);
                else if (c == '*')  stack.push(num2 * num1);
                else                stack.push(num2 / num1);
            }
        }
        return stack.peek();
    }
}