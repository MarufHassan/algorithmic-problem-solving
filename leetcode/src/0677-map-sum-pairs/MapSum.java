class MapSum {

    private static int R = 26;
    
    private class Node {
        int val;
        Node[] next = new Node[R];
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        root = insert(root, key, val, 0);
    }
    
    private Node insert(Node x, String key, int val, int d) {
        if (x == null)
            x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c - 'a'] = insert(x.next[c - 'a'], key, val, d + 1);
        
        return x;
    }
    
    public int sum(String prefix) {
        Node x = search(root, prefix, 0);
        return sum(x);
    }
    
    private int sum(Node x) {
        if (x == null)
            return 0;
        int sum = x.val;
        for (int i = 0; i < R; i++) {
            sum += sum(x.next[i]);
        }
        return sum;
    }
    
    private Node search(Node x, String word, int d) {
        if (x == null)  return null;
        if (d == word.length()){
            return x;
        }
        char c = word.charAt(d);
        
        return search(x.next[c - 'a'], word, d + 1);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */