# [28. Implement strStr()][title]

## Problem Description

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

## Solution

**Approach 1: Brute Force**

```java
public int strStr(String txt, String pat) {
    int n = txt.length(), m = pat.length();
    if (m <= 0)
        return m;
    if (n < m)
        return -1;
    
    for (int i = 0; i <= n - m; i++) {
        if (equal(txt, pat, i))
            return i;
    }
    return -1;
}
```

**private helper method**

```java
private boolean equal(String txt, String pat, int i) {
    int m = pat.length();
    for (int j = 0; j < m; j++) {
        if (pat.charAt(j) != txt.charAt(i + j))
            return false;
    }
    return true;
}
```

**Approach 2: Rabin-Karp's Algorithm**

```java
private static int R = 256; // radix
private static long Q = 1597018849L; // a large prime, small enough to avoid long overflow

public int strStr(String txt, String pat) {
    int n = txt.length(), m = pat.length();
    if (m <= 0)
        return m;
    if (n < m)
        return -1;
    
    long patHash = hash(pat, m); // pattern hash
    long txtHash = hash(txt, m); // text hash

    if ((patHash == txtHash) && check(txt, pat, 0))
        return 0;
    
    // precompute R^(m-1) % Q for use in removing leading char
    long RM = 1;
    for (int i = 1; i <= m-1; i++)
        RM = (R * RM) % Q;

    // check for hash match; if hash match, check for exact match
    for (int i = m; i < n; i++) {
        // Remove leading char, add trailing char, check for match.
        txtHash = (txtHash + Q - RM*txt.charAt(i-m) % Q) % Q; 
        txtHash = (txtHash*R + txt.charAt(i)) % Q; 

        // match
        int offset = i - m + 1;
        if ((patHash == txtHash) && check(txt, pat, offset))
            return offset;
    }
    
    return -1;
}
```

**private helper methods**

```java
private boolean check(String txt, String pat, int i) {
    int m = pat.length();
    for (int j = 0; j < m; j++) {
        if (pat.charAt(j) != txt.charAt(i + j))
            return false;
    }
    return true;
}

// Compute hash for key[0..m-1]. 
private long hash(String key, int m) { 
    long h = 0;
    for (int j = 0; j < m; j++) 
        h = (R * h + key.charAt(j)) % Q;
    return h;
}
```

## Test

Compile with `javac TimeMap.java` and run with `java TimeMap`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/string-without-aaa-or-bbb/