class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null)
            return averages;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int len = q.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode x = q.poll();
                sum += x.val;
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
            averages.add(sum / len);
        }
        return averages;
    }
}