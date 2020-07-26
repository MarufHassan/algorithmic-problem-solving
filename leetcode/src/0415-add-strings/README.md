# [415. Add Strings][title]

## Problem Description

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Detail instruction can be found [here][title].

**Example 1:**

```
Example:
Input: 
    "0"
    "0"
    "0000"
    "00"
    "123"
    "234"
Output:
    "0"
    "0000"
    "357"
```

## Solution

```java
public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1;
    int carry = 0, sum = 0;
    StringBuilder ans = new StringBuilder();
    
    while (i >= 0 || j >= 0 || carry != 0) {
        sum = carry;
        sum += (i >= 0 ? num1.charAt(i) - '0' : 0);
        sum += (j >= 0 ? num2.charAt(j) - '0' : 0);
        
        ans.append(sum % 10);
        carry = sum / 10;
        i--; j--;
    }
    
    return ans.reverse().toString();
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-strings/