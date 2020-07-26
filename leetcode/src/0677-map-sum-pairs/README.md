# [677. Map Sum Pairs][title]

## Problem Description

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

**Example:**

```
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
```

## Solution

```java
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
```

```java
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
```

**Node class**

```java
private class Node {
    int val;
    Node[] next = new Node[R];
}
```

## Test

Compile with `javac WordDictionary.java` and run with `java WordDictionary`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/map-sum-pairs/