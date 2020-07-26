# [541. Reverse String II][title]

## Problem Description

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```

## Solution

```java
public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int i, step = 2 * k;
    
    for (i = 0; i < chars.length; i += step) {
        int start = i, end = Math.min(i + k - 1, chars.length - 1);
        reverse(chars, start, end);
    }
    
    return new String(chars);
}
```

**private helper methods**

```java
private void reverse(char[] chars, int start, int end) {
    while (start < end) {
        char c = chars[start];
        chars[start++] = chars[end];
        chars[end--] = c;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-string-ii/