# [1134. Armstrong Number][title]

## Problem Description

The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.

Given a positive integer N, return true if and only if it is an Armstrong number.

**Example 1:**

```
Input: 153
Output: true

Explanation: 
153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
```

**Example 2:**

```
Input: 123
Output: false
Explanation: 
123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
```

## Solution

```java
public boolean isArmstrong(int N) {
    int result = 0, n = 0, remainder;
    
    int originalNumber = N;
    while (originalNumber != 0) {
        originalNumber /= 10;
        ++n;
    }
    
    originalNumber = N;
    while (originalNumber != 0) {
        remainder = originalNumber % 10;
        result += Math.pow(remainder, n);
        originalNumber /= 10;
    }
    return result == N;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/armstrong-number/