class Solution {
    private int next(int[] preorder, int lo, int hi, int val) {
        for (int i = lo; i <= hi; i++) {
            if (preorder[i] > val)
                return i;
        }
        return hi + 1;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode bst(int[] preorder, int lo, int hi) {
        if (hi < lo)
            return null;
        
        TreeNode x = new TreeNode(preorder[lo]);
        int idx = next(preorder, lo, hi, preorder[lo]);
        
        x.left = bst(preorder, lo + 1, idx - 1);
        x.right = bst(preorder, idx, hi);
        
        return x;
    }
}