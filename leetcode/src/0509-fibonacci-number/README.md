# [509. Fibonacci Number][title]

## Problem Description

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), for N > 1.

Given N, calculate F(N).

**Example 1:**

```
Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
```

**Example 2:**

```
Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
```

**Example 3:**

```
Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
```

## Solution

**Approach 1: Recursion**

```java
public int fib(int N) {
    if (N <= 1) return N;
    return fib(N - 1) + fib(N - 2);
}
```

**Approach 2: Better Recursion with dynamic programming**

```java
private Map<Integer, Integer> map = new HashMap<>();

public int fib(int N) {
    if (N <= 1) return N;
    int prev = (map.containsKey(N - 1) ? map.get(N - 1) : fib(N - 1));
    int next = (map.containsKey(N - 2) ? map.get(N - 2) : fib(N - 2));
    return prev + next;
}
```

**Approach 3: Iterative**

```java
public int fib(int N) {
    int prev = 0, curr = 1;
    for (int i = 2; i <= N + 1; i++) {
        int tmp = curr;
        curr += prev;
        prev = tmp;
    }
    return prev;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/fibonacci-number