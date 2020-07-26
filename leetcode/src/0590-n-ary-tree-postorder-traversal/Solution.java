class Solution {
    private List<Integer> nodes;
    
    public Solution() {
        nodes = new ArrayList<>();
    }
    
    public List<Integer> postorder(Node root) {
        if (root == null)
            return nodes;
        for (Node desc : root.children) {
            postorder(desc);
        }
        nodes.add(root.val);
        return nodes;
    }
}