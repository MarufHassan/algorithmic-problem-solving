# [1071. Greatest Common Divisor of Strings][title]

## Problem Description

For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

## Solution

```java
public String gcdOfStrings(String str1, String str2) {
    int lcm = lcm(str1.length(), str2.length());
    int gcd = gcd(str1.length(), str2.length());
    
    for (int i = 0; i < lcm; i++) {
        char c1 = str1.charAt(i % str1.length());
        char c2 = str2.charAt(i % str2.length());
        if (c1 != c2)
            return "";
    }
    
    return str1.substring(0, gcd);
}
```

**private helper methods**

```java
private int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}

private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/greatest-common-divisor-of-strings/