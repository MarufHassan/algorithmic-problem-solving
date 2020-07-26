class Solution {
    private String ans = "";
    
    public String smallestFromLeaf(TreeNode root) {
        traverse(root, "");
        return ans;
    }
    
    private void traverse(TreeNode root, String s) {
        if (root == null)   return;
        char c = (char) (root.val + 'a');
        s += c;
        
        if (root.left == null && root.right == null) {
            String rev = reverse(s);
            if (ans == "") ans = rev;
            else if (rev.compareTo(ans) < 0)
                ans = rev;
        }
        traverse(root.left, s);
        traverse(root.right, s);
    }
    
    private String reverse(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}