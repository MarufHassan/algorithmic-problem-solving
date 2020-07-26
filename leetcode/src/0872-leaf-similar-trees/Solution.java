class Solution {
    private List<Integer> nodes;
    
    public Solution() {
        nodes = new ArrayList<>();
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return nodes;
        inorderTraversal(root.left);
        nodes.add(root.val);
        inorderTraversal(root.right);
        return nodes;
    }
}