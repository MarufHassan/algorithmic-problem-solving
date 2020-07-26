# [67. Add Binary][title]

## Problem Description

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```
Input: a = "1010", b = "1011"
Output: "10101"
```

## Solution

```java
public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    StringBuilder ans = new StringBuilder();
    
    int carry = 0, s;
    while (i >= 0 || j >= 0 || carry != 0) {
        s = carry;
        s += (i >= 0) ? a.charAt(i) - '0' : 0;
        s += (j >= 0) ? b.charAt(j) - '0' : 0;
        
        ans.append(s % 2);
        carry = s / 2;
        
        i--; j--;
    }
    return ans.reverse().toString();
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-binary/