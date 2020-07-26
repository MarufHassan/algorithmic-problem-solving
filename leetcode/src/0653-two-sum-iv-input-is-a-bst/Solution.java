class Solution {
    public boolean findTarget(TreeNode root, int target) {
        List<Integer> elems = new ArrayList<>();
        inorder(root, elems);
        
        int lo = 0, hi = elems.size() - 1;
        while (lo < hi) {
            int sum = elems.get(lo) + elems.get(hi);
            if (sum < target) lo++;
            else if (sum > target) hi--; 
            else    return true;
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> elems) {
        if (root == null)  return;
        inorder(root.left, elems);
        elems.add(root.val);
        inorder(root.right,elems);
    }
}