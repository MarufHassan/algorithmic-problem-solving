class WordDictionary {
    private static int R = 26;
    
    private static class Node {
        boolean isEnd;
        Node[] next = new Node[R];
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root = insert(root, word, 0);
    }
    
    private Node insert(Node x, String word, int d) {
        if (x == null)
            x = new Node();
        if (d == word.length()) {
            x.isEnd = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c - 'a'] = insert(x.next[c - 'a'], word, d + 1);
        return x;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(Node x, String word, int d) {
        if (x == null)  return false;
        if (d == word.length()){
            return x.isEnd;
        }
        char c = word.charAt(d);
        if (c == '.') {
            for (int i = 0; i < R; i++) {
               if (search(x.next[i], word, d + 1))
                   return true;
            }
            return false;
        } 
        return search(x.next[c - 'a'], word, d + 1);
    }
}