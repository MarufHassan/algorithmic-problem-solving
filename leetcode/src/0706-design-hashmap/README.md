# [706. Design HashMap][title]

## Problem Description

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Detail instruction can be found [here][title].

**Example:**

```
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 
```

## Solution

**Approach 1:**

```java
class MyHashMap {
    private int[] table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new int[1000001];
        Arrays.fill(table, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        table[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return table[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        table[key] = -1;
    }
}
```

**Approach 2:**

```java
class MyHashMap {
    private LinkedList<Node>[] table;
    private int bucket;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = 10000;
        table = new LinkedList[bucket];
    }
    
    private int hash(int key) {
        return key % bucket;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        if (table[h] == null)
            table[h] = new LinkedList<>();
        Node n = new Node(key, value);
        table[h].removeFirstOccurrence(n);
        table[h].addFirst(n);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        if (table[h] == null)
            return -1;
        Node n = new Node(key, -1);
        int idx = table[h].indexOf(n);
        if (idx >= 0)
            return table[h].get(idx).val;
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        if (table[h] == null)
            return;
        Node n = new Node(key, -1);
        table[h].removeFirstOccurrence(n);
    }
    
    private static class Node {
        int key, val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public boolean equals(Object ob) {
            Node that = (Node) ob;
            return this.key == that.key;
        }
    }
}
```

**Approach 3:**

```java
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
```

## Test

Compile with `javac MyHashSet.java` and run with `java MyHashSet`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/design-hashset/