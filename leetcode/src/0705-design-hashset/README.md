# [705. Design HashSet][title]

## Problem Description

Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Detail instruction can be found [here][title].

**Example:**

```
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
```

## Solution

**Approach 1:**

```java
class MyHashSet {
    private boolean[] elems;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        elems = new boolean[1000001];
    }
    
    public void add(int key) {
        elems[key] = true;
    }
    
    public void remove(int key) {
        elems[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return elems[key];
    }
}
```

**Approach 2:**

```java
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
```

## Test

Compile with `javac MyHashSet.java` and run with `java MyHashSet`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/design-hashset/