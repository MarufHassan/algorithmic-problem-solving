# [966. Vowel Spellchecker][title]

## Problem Description

Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

For a given query word, the spell checker handles two categories of spelling mistakes:

Detail instruction can be found [here][title].

**Example 1:**

```
Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]

Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
```

## Solution

```java
public String[] spellchecker(String[] wordlist, String[] queries) {
    for (String word : wordlist) {
        perfect.add(word);
        
        String lowercase = word.toLowerCase();
        
        lower.putIfAbsent(lowercase, word);
        vowel.putIfAbsent(devowel(lowercase), word);
    }
    
    String[] ans = new String[queries.length];
    for (int i = 0; i < queries.length; i++) {
        ans[i] = solve(queries[i]);
    }
    return ans;
}

private String solve(String word) {
    if (perfect.contains(word))
        return word;
    
    String lo = word.toLowerCase();
    String ans = lower.get(lo);
    if (ans != null)
        return ans;
    
    String converted = devowel(word);
    ans = vowel.get(converted);
    if (ans != null)
        return ans;
    return "";
}
```

**private helper  methods**

```java
private String devowel(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        if (isVowel(chars[i]))
            chars[i] = '*';
        
    }
    return String.valueOf(chars);
}

private boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/vowel-spellchecker/