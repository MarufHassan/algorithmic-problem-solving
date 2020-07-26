# [367. Valid Perfect Square][title]

## Problem Description

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

**Example 1:**

```
Input: 16
Output: true
```

**Example 2:**

```
Input: 14
Output: false
```

## Solution

```java
public boolean isPerfectSquare(int num) {
    long lo = 1, hi = num;
    
    while (lo < hi) {
        long mid = lo + (hi - lo) / 2;
        
        if (mid * mid < num)
            lo = mid + 1;
        else
            hi = mid;
    }
    return (lo * lo == num);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-perfect-square/