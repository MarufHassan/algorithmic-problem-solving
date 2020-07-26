class Trie {
    private static int R = 26;
    
    private static class Node {
        boolean isEnd;
        Node[] next = new Node[R];
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = insert(root, word, 0);
    }
    
    private Node insert(Node x, String word, int d) {
        if (x == null)
            x = new Node();
        if (d == word.length()) {
            x.isEnd = true;
            return x;
        }
        
        int index = word.charAt(d) - 'a';
        x.next[index] = insert(x.next[index], word, d + 1);
        
        return x;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node x = search(root, word, 0);
        if (x == null)
            return false;
        return x.isEnd;
    }
    
    private Node search(Node x, String word, int d) {
        if (x == null)
            return null;
        if (d == word.length())
            return x;
        int index = word.charAt(d) - 'a';
        return search(x.next[index], word, d + 1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node x = search(root, prefix, 0);
        return x != null;
    }
}