class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stack.pop();
        TreeNode curr = ret.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return ret.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}