# [Implement strstr][title]

## Problem Description

Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string s. The function returns and integer denoting the first occurrence of the string x in s.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    GeeksForGeeks Fr
    GeeksForGeeks For
Output
	-1
    5
```

## Solution

**Approach 1: Brute Force**

```java
int strstr(String str, String target) {
    int len = str.length() - target.length() + 1;
    for (int i = 0; i < len; i++) {
        int index = matched(str, target, i);
        if (index >= 0)
            return index;
    }
    return -1;
}
```

**helper method**

```java
int matched(String s, String target, int pos) {
    for (int i = 0; i < target.length(); i++) {
        if (s.charAt(i + pos) != target.charAt(i))
            return -1;
        }
    return pos;
}
```

**Approach 2: Rabin-Karp's Algorithm**

```java
private static int R = 256; // radix
private static long Q = 1597018849L; // a large prime, small enough to avoid long overflow

public int strstr(String txt, String pat) {
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

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/implement-strstr/1/