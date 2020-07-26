class Solution {
    public Node connect(Node root) {
        Node start = root, curr;
        while (start != null) {
            curr = start;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                    if (curr.next != null)
                        curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            start = start.left;
        }
        return root;
    }
}