class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }
    
    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null)   return;
        if (root.left == null && root.right == null) {
            path += root.val;
            paths.add(path);
        }
        path += (root.val + "->");
        dfs(root.left, path, paths);
        dfs(root.right, path, paths);
    }
}