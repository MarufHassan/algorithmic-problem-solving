class Solution {
    private Map<Integer, Integer> freq;
    private int most;
    
    public Solution() {
        freq = new HashMap<>();
        most = 0;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);
        int[] ans = new int[freq.size()];
        int idx = 0;
        for (int s : freq.keySet()) {
            int val = freq.get(s);
            if (val == most)
                ans[idx++] = s;
        }
        return Arrays.copyOf(ans, idx);
    }
    
    private int traverse(TreeNode root) {
        if (root == null)   return 0;
        
        int left = traverse(root.left);
        int right = traverse(root.right);
        
        int s = root.val + left + right;
        
        freq.put(s, freq.getOrDefault(s, 0) + 1);
        most = Math.max(most, freq.get(s));
        
        return s;
    }
}