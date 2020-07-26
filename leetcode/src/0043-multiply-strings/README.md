# [43. Multiply Strings][title]

## Problem Description

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

**Example 1:**

```
Input: num1 = "2", num2 = "3"
Output: "6"
```

**Example 2:**

```
Input: num1 = "123", num2 = "456"
Output: "56088"
```

## Solution

```java
public String multiply(String num1, String num2) {
    int n = num1.length(), m = num2.length();
    char[] ans = new char[m + n];
    Arrays.fill(ans, '0');
    
    for (int i = m - 1; i >= 0; i--) {
        int d2 = num2.charAt(i) - '0';
        
        int s, carry = 0;
        for (int j = n - 1; j >= 0; j--) {
            int d1 = num1.charAt(j) - '0';
            s = d1 * d2 + carry;
            s += (ans[i + j + 1] - '0');
            ans[i + j + 1] = (char) ((s % 10) + '0');
            carry = s / 10;
        }
        ans[i] = (char) (carry + '0');
    }
    
    for (int i = 0; i < m + n; i++) {
        if (ans[i] != '0') 
            return new String(ans, i, (m + n) - i);
    }
    
    return "0";
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/multiply-strings/