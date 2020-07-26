public class Solution {
    public List<Integer> preorder(Node root) {
	    List<Integer> nodes = new ArrayList<>();
	    traverse(root, nodes);
	    return nodes;
	}

	private void traverse(Node x, List<Integer> nodes) {
	    if (x == null)  return;
	    nodes.add(x.val);
	    for (Node descendent : x.children) {
	        traverse(descendent, nodes);
	    }
	}
}