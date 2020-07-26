# [69. Sqrt(x)][title]

## Problem Description

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

## Solution

```java
public int mySqrt(int x) {
    long lo = 1, hi = x;
    while (lo < hi) {
        long mid = lo + (hi - lo) / 2;
        
        if (mid * mid <= x)
            lo = mid + 1;
        else
            hi = mid;
    }
    
    return (int) (lo * lo <= x ? lo : lo - 1);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/sqrtx/