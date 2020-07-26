class Solution {
    private Map<Integer, Integer> freq;
    private int max;
    
    public Solution() {
        freq = new HashMap<>();
        max = 0;
    }
    
    public int[] findMode(TreeNode root) {
        count(root);
        List<Integer> modes = new ArrayList<>();
        for (int key : freq.keySet()) {
            int val = freq.get(key);
            if (val == max)
                modes.add(key);
        }
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = modes.get(i);
        
        return res;
    }
    
    private void count(TreeNode root) {
        if (root == null) return;
        int val = freq.getOrDefault(root.val, 0);
        max = Math.max(val + 1, max);
        freq.put(root.val, val + 1);
        
        count(root.left);
        count(root.right);
    }
}