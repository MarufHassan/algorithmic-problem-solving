# [890. Find and Replace Pattern][title]

## Problem Description

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

**Example 1:**

```
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]

Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
```

## Solution

```java
public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    int[] ref = codes(pattern);
    
    for (String word : words) {
        int[] t = codes(word);
        if (Arrays.equals(ref, t))
            res.add(word);
    }
    
    return res;
}
```

**private helper  methods**

```java
private int[] codes(String s) {
    int[] code = new int[s.length()];
    Map<Character, Integer> map = new HashMap<>();
    
    int i = 0;
    for (char c : s.toCharArray()) {
        map.putIfAbsent(c, map.size());
        code[i++] = map.get(c);
    }
    
    return code;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-and-replace-pattern/