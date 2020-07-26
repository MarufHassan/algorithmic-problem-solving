# [383. Ransom Note][title]

## Problem Description

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Detail instruction can be found [here][title].

**Example:**

```
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
```

## Solution

**Approach 1: Two pass**

```java
public boolean canConstruct(String ransomNote, String magazine) {
    int[] freq = new int[128];
    
    for (int i = 0; i < magazine.length(); i++) {
        char c = magazine.charAt(i);
        freq[c]++;
    }
    
    for (int i = 0; i < ransomNote.length(); i++) {
        char c = ransomNote.charAt(i);
        freq[c]--;
        if (freq[c] < 0)
            return false;
    }

    return true;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/ransom-note/