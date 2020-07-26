# [1016. Binary String With Substrings Representing 1 To N][title]

## Problem Description

Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

**Example 1:**

```
Input: S = "0110", N = 3
Output: true
```

**Example 2:**

```
Input: S = "0110", N = 4
Output: false
```

## Solution

**Approach 1: Brute Force (AC)**

```java
public boolean queryString(String S, int N) {
    for (int i = N; i >= 1; i--) {
        int idx = S.indexOf(Integer.toBinaryString(i));
        if (idx < 0)    return false;
    }
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/