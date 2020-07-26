class Solution {
    private Map<Integer, Integer> index;
    
    public Solution() {
        index = new HashMap<>();
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length - 1, 0);
    }
    
    private TreeNode construct(int[] preorder, int lo, int hi, int pivot) {
        if (hi < lo)    return null;
        
        int idx = index.get(preorder[pivot]);
        TreeNode node = new TreeNode(preorder[pivot]);
        
        node.left = construct(preorder, lo, idx - 1, pivot + 1);
        node.right = construct(preorder, idx + 1, hi, pivot + (idx - lo + 1));
        
        return node;
    }
}