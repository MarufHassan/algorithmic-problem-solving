# [Count Smaller elements][title]

## Problem Description

Given a positive integer N, find the Nth Even Fibonacci number. Since the answer can be very large, print the answer modulo 1000000007.

Detailed description can be found [here][title]

**Example:**

```
Input
	3
    1
    2
    5
Output
	2
    8
    610
```

## Solution

```java
public static long[] preCompute() {
    long[] fibs = new long[1001];
    long m = 1000000007;
    
    long prev = 1, curr = 1, ldPrev = 1, ldCurr = 1;
    for (int i = 3, j = 1; i < 3003; i++) {
        long tmpPrev = curr, tmpldPrev = ldCurr;
        curr = (prev + curr) % m;
        ldCurr = (ldPrev + ldCurr) % 10;
        if (ldCurr % 2 == 0) {
            fibs[j++] = curr;
        }
        prev = tmpPrev;
        ldPrev = tmpldPrev;
    }
    
    return fibs;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/nth-even-fibonacci-number/0/