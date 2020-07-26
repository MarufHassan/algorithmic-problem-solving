class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}