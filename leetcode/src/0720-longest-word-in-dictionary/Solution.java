class Solution {
    private static int R = 26;
    private Node root = new Node();
    private String res = "";
    
    public String longestWord(String[] words) {
        for (String word : words) {
            root = put(root, word, 0);
        }
        
        String candidate = "";
        
        for (String word : words) {
            if (search(root, word, 0)) {
                if (word.length() > candidate.length() || word.length() == candidate.length() && word.compareTo(candidate) < 0) {
                    candidate = word;
                }
            }
        }
        return candidate;
    }
    
    private boolean search(Node x, String key, int d) {
        if (x == null) return false;
        if (x != root && !x.isEnd)   return false;
        if (d == key.length()) 
            return true;
        int index = key.charAt(d) - 'a';
        return search(x.next[index], key, d + 1);
    }
    
    private Node put(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.isEnd = true; return x;
        }
        int index = key.charAt(d) - 'a';
        x.next[index] = put(x.next[index], key, d + 1);
        return x;
    }
    
    class Node {
        boolean isEnd;
        Node[] next = new Node[R];
    }
}