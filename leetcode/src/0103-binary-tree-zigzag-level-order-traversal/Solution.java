class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)   return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean order = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> levels = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.remove();
                if (order)
                    levels.addLast(x.val);
                else
                    levels.addFirst(x.val);
                if (x.left  != null)    q.offer(x.left);
                if (x.right != null)    q.offer(x.right);
            }
            ans.add(levels);
            order = !order;
        }
        return ans;
    }
}