# [720. Longest Word in Dictionary][title]

## Problem Description

Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

Detail instruction can be found [here][title].

**Example 1**

```
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"

Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
```

**Example 2**

```
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"

Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
```

## Solution

```java
private static int R = 26;
private Node root = new Node();
private String res = "";

public String longestWord(String[] words) {
    for (String word : words) {
        root = put(root, word, 0);
    }
    
    String candidate = "";
    
    for (String word : words) {
        if (search(root, word, 0)) {
            if (word.length() > candidate.length() || word.length() == candidate.length() && word.compareTo(candidate) < 0) {
                candidate = word;
            }
        }
    }
    return candidate;
}
```

**private helper methods**

```java
private boolean search(Node x, String key, int d) {
    if (x == null) return false;
    if (x != root && !x.isEnd)   return false;
    if (d == key.length()) 
        return true;
    int index = key.charAt(d) - 'a';
    return search(x.next[index], key, d + 1);
}

private Node put(Node x, String key, int d) {
    if (x == null) x = new Node();
    if (d == key.length()) {
        x.isEnd = true; return x;
    }
    int index = key.charAt(d) - 'a';
    x.next[index] = put(x.next[index], key, d + 1);
    return x;
}
```

**private helper class**

```java
class Node {
    boolean isEnd;
    Node[] next = new Node[R];
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/longest-word-in-dictionary/