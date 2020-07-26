# [344. Reverse String][title]

## Problem Description

Write a function that reverses a string. The input string is given as an array of characters char[].

Detail instruction can be found [here][title].

**Example 1:**

```
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

**Example 2:**

```
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

## Solution

```java
public void reverseString(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
        exch(s, i, n - i - 1);
    }
}
```

**private helper methods**

```java
private void exch(char[] s, int i, int j) {
    char c = s[i];
    s[i] = s[j];
    s[j] = c;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-string/