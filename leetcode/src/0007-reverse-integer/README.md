# [7. Reverse Integer][title]

## Problem Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output: 321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

## Solution

```java
public int reverse(int x) {
    int num = 0;
    int tmax = Integer.MAX_VALUE / 10;
    int tmin = Integer.MIN_VALUE / 10;
    while (x != 0) {
        int pop = x % 10;
        
        if (num > tmax || (num == tmax / 10 && pop > 7))
            return 0;
        if (num < tmin || (num == tmin && pop < -8))
            return 0;

        num = (num * 10) + pop;            
        x = x / 10;
    }      
    return num;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-integer/