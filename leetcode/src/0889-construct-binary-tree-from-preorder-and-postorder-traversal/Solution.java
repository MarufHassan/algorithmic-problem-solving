class Solution {
    private Map<Integer, Integer> index;
    
    public Solution() {
        index = new HashMap<>();
    }
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if (n == 0)    return null;
        
        for (int i = 0; i < n; i++) {
            index.put(post[i], i);
        }
        
        return construct(pre, post, 0, n - 1, 0);
    }
    
    private TreeNode construct(int[] pre, int[] post, int lo, int hi, int pivot) {
        if (hi < lo)    return null;
        if (lo == hi)   return new TreeNode(post[lo]);
        
        TreeNode x = new TreeNode(post[hi]);
        
        int idx = index.get(pre[pivot + 1]);
        
        x.left = construct(pre, post, lo, idx, pivot + 1);
        x.right = construct(pre, post, idx + 1, hi - 1, pivot + (idx - lo + 1) + 1);
        
        return x;
    }
}