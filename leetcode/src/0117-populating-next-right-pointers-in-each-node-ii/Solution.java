class Solution {
    public Node connect(Node root) {
        if (root == null)   return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node next, curr;
        while (!q.isEmpty()) {
            int size = q.size();
            next = null;
            for (int i = 0; i < size; i++) {
                curr = q.remove();
                curr.next = next;
                if (curr.right != null)
                    q.offer(curr.right);
                if (curr.left != null)
                    q.offer(curr.left);
                next = curr;
            }
        }
        return root;
    }
}