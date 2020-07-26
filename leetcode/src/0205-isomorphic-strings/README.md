# [205. Isomorphic Strings][title]

## Problem Description

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

**Example 1:**

```
Input: s = "egg", t = "add"
Output: true
```

**Example 2:**

```
Input: s = "foo", t = "bar"
Output: false
```

**Example 3:**

```
Input: s = "paper", t = "title"
Output: true
```

## Solution


```java
public boolean isIsomorphic(String s, String t) {
    int[] index = new int[256];
    
    for (int i = 0; i < s.length(); i++) {
        int c1 = s.charAt(i);
        int c2 = t.charAt(i) + 128;
        if (index[c1] != index[c2])
            return false;
        index[c1] = index[c2] = i + 1;
    }
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/isomorphic-strings/