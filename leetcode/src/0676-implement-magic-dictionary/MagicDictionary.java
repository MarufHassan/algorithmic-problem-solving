class MagicDictionary {

    private static int R = 26;
    
    private class Node {
        boolean isEnd;
        Node[] next = new Node[R];
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            root = insert(root, word, 0);
        }
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
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (t != c) {
                    chars[i] = c;
                    if (search(root, chars, 0))
                        return true;
                }
            }
            chars[i] = t;
        }
        
        return false;
    }
    
    private boolean search(Node x, char[] word, int d) {
        if (x == null)  return false;
        if (d == word.length){
            return x.isEnd;
        }
        char c = word[d];
        return search(x.next[c - 'a'], word, d + 1);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */