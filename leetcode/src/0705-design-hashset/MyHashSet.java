class MyHashSet {
    private boolean[][] table;
    private int bucket;
    private int items;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        items = 1001;
        table = new boolean[bucket][];
    }
    
    private int hash(int key) {
        return key % bucket;
    }
    
    private int pos(int key) {
        return key / bucket;
    }
    
    public void add(int key) {
        int h = hash(key);
        if (table[h] == null)
            table[h] = new boolean[items];
        table[h][pos(key)] = true;
    }
    
    public void remove(int key) {
        int h = hash(key);
        if (table[h] != null)
            table[h][pos(key)] = false;
            
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        if (table[h] == null)
            return false;
        return table[h][pos(key)];
    }
}