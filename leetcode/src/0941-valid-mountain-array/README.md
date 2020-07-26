# [941. Valid Mountain Array][title]

## Problem Description

Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

    A.length >= 3
    There exists some i with 0 < i < A.length - 1 such that:
    A[0] < A[1] < ... A[i-1] < A[i]
    A[i] > A[i+1] > ... > A[B.length - 1]

**Example 1:**

```
Input: [2,1]
Output: false
```

**Example 2:**

```
Input: [3,5,5]
Output: false
```

**Example 3:**

```
Input: [0,3,2,1]
Output: true
```

## Solution

```java
public boolean validMountainArray(int[] A) {
    int n = A.length;
    if (n < 3) return false;
    
    int loPtr = 0, hiPtr = A.length - 1;
    while (loPtr < n - 1 && A[loPtr] < A[loPtr + 1])
        loPtr++;
    while (hiPtr > 0 && A[hiPtr - 1] > A[hiPtr])
        hiPtr--;
    return loPtr < n - 1 && hiPtr > 0 && loPtr == hiPtr;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-mountain-array/