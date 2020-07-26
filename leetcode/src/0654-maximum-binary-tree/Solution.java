class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = null;
        for (int i = 0; i < nums.length; i++) {
            curr = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty())
                stack.peek().right = curr;
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            curr = stack.pop();
        }
        return curr;
    }
}