class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int maxDepth = 1;
        for (Node x : root.children) {
            maxDepth = Math.max(maxDepth, 1 + maxDepth(x));
        }
        return maxDepth;
    }
}