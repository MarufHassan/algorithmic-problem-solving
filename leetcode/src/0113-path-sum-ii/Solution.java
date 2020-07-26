class Solution {
    private List<List<Integer>> sums;
    
    public Solution() {
        sums = new ArrayList<>();
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new Stack<>());
        return sums;
    }
    
    private void dfs(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null)   return;
        path.push(root.val);
        
        if (root.left == null && root.right == null && root.val == sum){
            sums.add(new ArrayList<>(path));
        }
        
        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);
        path.pop();
    }
}