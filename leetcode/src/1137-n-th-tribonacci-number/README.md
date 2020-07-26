# [1137. N-th Tribonacci Number][title]

## Problem Description

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

**Example 1:**

```
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
```

**Example 2:**

```
Input: n = 25
Output: 1389537
```

## Solution

```java
public int tribonacci(int n) {
    int[] fibs = new int[40];
    fibs[0] = 0; fibs[1] = 1; fibs[2] = 1;
    
    for (int i = 3; i < 40; i++) {
        fibs[i] = fibs[i - 1] + fibs[i - 2] + fibs[i - 3];
    }
    return fibs[n];
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/n-th-tribonacci-number/