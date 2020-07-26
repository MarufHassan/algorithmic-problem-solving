class Solution {
    private Map<Integer, Integer> index;
    
    public Solution() {
        index = new HashMap<>();
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return construct(postorder, 0, postorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode construct(int[] postorder, int lo, int hi, int pivot) {
        if (hi < lo)    return null;
        
        int idx = index.get(postorder[pivot]);
        TreeNode node = new TreeNode(postorder[pivot]);
        
        node.right = construct(postorder, idx + 1, hi, pivot - 1);
        node.left = construct(postorder, lo, idx - 1,  pivot - (hi - idx + 1));
        
        return node;
    }
}