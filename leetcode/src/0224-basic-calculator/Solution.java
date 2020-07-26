class Solution {
    public int calculate(String s) {
        int[] precedence = new int[128];
        precedence['+'] = 1; precedence['-'] = 1;
        precedence['*'] = 2; precedence['/'] = 2;
        
        Stack<Integer> vals = new Stack<>();
        Stack<Character> ops = new Stack<>();
        System.out.println(Arrays.toString(split(s)));
        
        for (String token : split(s)) {
            char c = token.charAt(token.length() - 1);
            if (Character.isDigit(c))
                vals.push(Integer.parseInt(token));
            else if (c == '(')
                ops.push(c);
            else if (c ==  ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int num2 = vals.pop();
                    int num1 = vals.pop();
                    int result = operate(num1, num2, ops.pop());
                    vals.push(result);
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && precedence[ops.peek()] >= precedence[c]) {
                    int num2 = vals.pop();
                    int num1 = vals.pop();
                    int result = operate(num1, num2, ops.pop());
                    vals.push(result);
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            int num2 = vals.pop();
            int num1 = vals.pop();
            int result = operate(num1, num2, ops.pop());
            vals.push(result);
        }
        
        return vals.pop();
    }
    
    private int operate(int a, int b, char op){ 
        switch(op) {
            case '+': return a + b; 
            case '-': return a - b; 
            case '*': return a * b; 
            case '/': return a / b; 
        }
        return -1;
    }
    
    // not efficient but easy to understand
    private String[] split(String s) {        
        String[] chars = {"+", "-", "*", "/", "(", ")"};

        for (String character : chars) {
            s = s.replace(character, " " + character + " ");
        }
        s = s.trim();
        return s.split(" +");
    }
}