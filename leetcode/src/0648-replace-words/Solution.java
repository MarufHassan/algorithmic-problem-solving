class Solution {
    private static int R = 26;
    
    private static class Node {
        boolean isEnd;
        Node[] next = new Node[R];
    }
    
    private Node root;
    
    public Solution() {
        root = new Node();
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        build(dict); // build trie
        
        StringBuilder ans = new StringBuilder();
        String[] splits = sentence.split(" ");
        
        for (int i = 0; i < splits.length; i++) {
            String word = splits[i];
            String x = search(root, word, "", 0);
            if (x.length() != 0)
                ans.append(x);
            if (i != splits.length - 1)
                ans.append(" ");
        }
        
        return ans.toString();
    }
    
    private String search(Node x, String s, String ans, int d) {
        if (x == null)  return s;
        if (x.isEnd || d == s.length())
            return ans;
        char c = s.charAt(d);
        return search(x.next[c - 'a'], s, ans + c, d + 1);
    }
    
    private void build(List<String> dict) {
        for (String word : dict) {
            root = insert(root, word, 0);
        }
    }
    
    private Node insert(Node x, String s, int d) {
        if (x == null)  x = new Node();
        if (d == s.length()) {
            x.isEnd = true;
            return x;
        }
        char c = s.charAt(d);
        x.next[c - 'a'] = insert(x.next[c - 'a'], s, d + 1);
        
        return x;
    }
}