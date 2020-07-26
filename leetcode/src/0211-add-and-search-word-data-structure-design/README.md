# [211. Add and Search Word - Data structure design][title]

## Problem Description

Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

**Example:**

```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```

## Solution

**addWord(String word)**

```java
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
```

**search(String word)**

```java
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
```

**Node class**

```java
private static class Node {
    boolean isEnd;
    Node[] next = new Node[R];
}
```

## Test

Compile with `javac WordDictionary.java` and run with `java WordDictionary`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-and-search-word-data-structure-design/