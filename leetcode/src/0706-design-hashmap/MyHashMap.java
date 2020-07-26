class MyHashMap {
    private Node[] table;
    private int bucket;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = 10000;
        table = new Node[bucket];
    }
    
    private int hash(int key) {
        return key % bucket;
    }
    
    private Node find(Node x, int key) {
        Node prev = x;
        while (x != null && x.key != key) {
            prev = x;
            x = x.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        if (table[h] == null)
            table[h] = new Node(-1, -1);
        
        Node prev = find(table[h], key);
        if (prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        if (table[h] == null)
            return -1;
        
        Node prev = find(table[h], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        if (table[h] == null)
            return;
        Node prev = find(table[h], key);
        if (prev.next != null)
            prev.next = prev.next.next;
    }
    
    private static class Node {
        int key, val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}