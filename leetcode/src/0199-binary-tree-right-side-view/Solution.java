class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        TreeNode curr, prev;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            prev = null;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                prev = curr;
            }
            ans.add(prev.val);
        }
        
        return ans;
    }
}