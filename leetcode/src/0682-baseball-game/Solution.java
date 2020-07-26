class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (s.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        int points = 0;
        for (int p : stack) points += p;
        
        return points;
    }
}