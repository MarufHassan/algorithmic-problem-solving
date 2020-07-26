class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)   return null;
        
        if      (key < root.val) root.left  = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)  return root.right;  // no left child
            if (root.right == null) return root.left;   // no right child
            
            // replace with successor
            TreeNode t = root;
            root = min(t.right);
            root.right = deleteNode(t.right, root.val); // delete min
            root.left = t.left;
        }
        return root;
    }
    
    private TreeNode min(TreeNode x) {
        if (x.left == null) return x;
        return min(x.left);
    }
}