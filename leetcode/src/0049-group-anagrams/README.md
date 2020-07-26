# [242. Valid Anagram][title]

## Problem Description

Given two strings s and t , write a function to determine if t is an anagram of s.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

## Solution


```java
public boolean isAnagram(String s, String t) {
    return Arrays.equals(frequency(s), frequency(t));
}

private int[] frequency(String s) {
    int[] count = new int[26];
    for(char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-anagram/