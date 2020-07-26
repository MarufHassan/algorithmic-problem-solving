class Solution {
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node x = que.poll();
                level.add(x.val);
                for (Node desc : x.children) {
                    que.add(desc);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}