# [978. Longest Turbulent Subarray][title]

## Problem Description

**Example 1:**

```
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
```

**Example 2:**

```
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

## Solution

```java
public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
        A[i] = A[i] * A[i];
    }
    Arrays.sort(A);
    return A;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/squares-of-a-sorted-array/