class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (level < d - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
            level += 1;
        }
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            TreeNode left = x.left;
            TreeNode right = x.right;
            x.left = new TreeNode(v);
            x.left.left = left;
            x.right = new TreeNode(v);
            x.right.right = right;
        }        
        return root;
    }
}
