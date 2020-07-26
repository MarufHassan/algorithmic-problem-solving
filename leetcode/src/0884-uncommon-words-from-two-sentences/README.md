# [884. Uncommon Words from Two Sentences][title]

## Problem Description

We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

**Example 1:**

```
Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
```

## Solution

```java
public String[] uncommonFromSentences(String A, String B) {
    String[] ans = new String[100];
    int idx = 0;
    Map<String, Integer> freq = new HashMap<>();
    
    for (String word : A.split(" ")) {
        freq.put(word, freq.getOrDefault(word, 0) + 1);
    }
    
    for (String word : B.split(" ")) {
        freq.put(word, freq.getOrDefault(word, 0) + 1);
    }
    
    for (String word : freq.keySet()) {
        if (freq.get(word) == 1)
            ans[idx++] = word;
    }
    
    return Arrays.copyOf(ans, idx);
}
```

## Test

Compile with `javac TopVotedCandidate.java` and run with `java TopVotedCandidate`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/uncommon-words-from-two-sentences/