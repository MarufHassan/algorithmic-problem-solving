class Solution {
    private List<TreeNode> nodes;
    
    public Solution() {
        nodes = new ArrayList<>();
    }
    
    public void flatten(TreeNode root) {
        traverse(root);
        TreeNode x = root;
        for (int i = 1; i < nodes.size(); i++) {
            x.right = nodes.get(i);
            x.left = null;
            x = x.right;
        }
    }
    
    private void traverse(TreeNode root) {
        if (root == null)   return;
        nodes.add(root);
        traverse(root.left);
        traverse(root.right);
    }
}