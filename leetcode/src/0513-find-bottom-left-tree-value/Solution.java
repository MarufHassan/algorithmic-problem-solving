class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        TreeNode prev = null, curr;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                curr = q.remove();
                if (curr.right != null)
                    q.offer(curr.right);
                if (curr.left != null)
                    q.offer(curr.left);
                prev = curr;
            }
        }
        return prev.val;
    }
}