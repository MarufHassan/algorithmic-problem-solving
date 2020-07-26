# [537. Complex Number Multiplication][title]

## Problem Description

Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

**Example 1:**

```
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
```

**Example 2:**

```
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
```

## Solution


```java
public String complexNumberMultiply(String n1, String n2) {
    String[] s1 = n1.split("\\+");
    String[] s2 = n2.split("\\+");
    
    int a = Integer.parseInt(s1[0]);
    int b = Integer.parseInt(s1[1].substring(0, s1[1].length() - 1));
    int c = Integer.parseInt(s2[0]);
    int d = Integer.parseInt(s2[1].substring(0, s2[1].length() - 1));
    
    int s = a * c + (-1 * b * d);
    int i = a * d + b * c;
    
    return s + "+" + i + "i";
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/complex-number-multiplication/