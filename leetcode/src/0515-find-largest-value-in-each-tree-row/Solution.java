class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                largest = Math.max(largest, x.val);
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
            ans.add(largest);
        }
        return ans;
    }
}