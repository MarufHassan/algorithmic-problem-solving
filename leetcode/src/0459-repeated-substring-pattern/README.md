# [459. Repeated Substring Pattern][title]

## Problem Description

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "abab"
Output: True

Explanation: It's the substring "ab" twice.
```

**Example 2:**

```
Input: "abab"
Output: True

Explanation: It's the substring "ab" twice.
```

**Example 3:**

```
Input: "abcabcabcabc"
Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
```

## Solution

```java
public boolean repeatedSubstringPattern(String s) {
    int len = s.length();
    for (int i = 1; i <= len / 2; i++) {
        if (len % i == 0) {
            String shifted = shiftLeft(s, i);
            if (shifted.equals(s))
                return true;
        }
    }
    return false;
}
```

**private helper method**

```java
private String shiftLeft(String s, int len) {
    String ret = s.substring(len);
    ret += s.substring(0, len);
    return ret;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/repeated-substring-pattern/