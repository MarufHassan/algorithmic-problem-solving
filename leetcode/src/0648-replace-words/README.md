# [648. Replace Words][title]

## Problem Description

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

**Example 1:**

```
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
```

## Solution

**Approach: Trie**

**build the trie**

```java
private void build(List<String> dict) {
    for (String word : dict) {
        root = insert(root, word, 0);
    }
}

private Node insert(Node x, String s, int d) {
    if (x == null)  x = new Node();
    if (d == s.length()) {
        x.isEnd = true;
        return x;
    }
    char c = s.charAt(d);
    x.next[c - 'a'] = insert(x.next[c - 'a'], s, d + 1);
    
    return x;
}
```

**search for matching word**

```java
private String search(Node x, String s, String ans, int d) {
    if (x == null)  return s;
    if (x.isEnd || d == s.length())
        return ans;
    char c = s.charAt(d);
    return search(x.next[c - 'a'], s, ans + c, d + 1);
}
```

**solution**

```java
public String replaceWords(List<String> dict, String sentence) {
    build(dict); // build trie
    
    StringBuilder ans = new StringBuilder();
    String[] splits = sentence.split(" ");
    
    for (int i = 0; i < splits.length; i++) {
        String word = splits[i];
        String x = search(root, word, "", 0);
        if (x.length() != 0)
            ans.append(x);
        if (i != splits.length - 1)
            ans.append(" ");
    }
    
    return ans.toString();
}
```

**Trie Node class**

```java
private static class Node {
    boolean isEnd;
    Node[] next = new Node[R];
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/replace-words/