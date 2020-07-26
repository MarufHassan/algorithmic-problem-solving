import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<Integer>();

        int i, j;

        for (i = 0, j = 0; i < pushed.length; i++) {
        	stack.push(pushed[i]);
        	while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
        		stack.pop();
        		j++;
        	}
        }
        return stack.isEmpty() || j >= popped.length;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] pushed = {1, 2, 3, 4, 5};
    	int[] popped = {4, 5, 3, 2, 1};
    	assert s.validateStackSequences(pushed, popped);

    	pushed = new int[] {1, 2, 3, 4, 5};
    	popped = new int[] {4, 3, 5, 1,2};
    	assert !s.validateStackSequences(pushed, popped);

    	pushed = new int[] {1, 2, 3, 4, 5};
    	popped = new int[] {1, 2, 3, 4, 5};
    	assert s.validateStackSequences(pushed, popped);

    	pushed = new int[] {1, 2, 3, 4, 5};
    	popped = new int[] {1, 2, 3};
    	assert s.validateStackSequences(pushed, popped);

    	pushed = new int[] {1, 2, 3};
    	popped = new int[] {1, 2, 3, 4, 5};
    	assert s.validateStackSequences(pushed, popped);
    }
}