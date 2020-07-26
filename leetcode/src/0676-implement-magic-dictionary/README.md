# [676. Implement Magic Dictionary][title]

## Problem Description

Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

**Example:**

```
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
```

## Solution

```java
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
```

```java
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
```

**Node class**

```java
private static class Node {
    boolean isEnd;
    Node[] next = new Node[R];
}
```

## Test

Compile with `javac MagicDictionary.java` and run with `java MagicDictionary`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/implement-magic-dictionary/