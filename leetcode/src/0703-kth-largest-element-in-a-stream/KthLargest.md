# [978. Longest Turbulent Subarray][title]

## Problem Description

**Example 1:**

```
Input: [9,4,2,10,7,8,8,1,9]
Output: 5

Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
```

**Example 2:**

```
Input: [4,8,12,16]

Output: 2
```

**Example 3:**

```
Input: [100]
Output: 1
```

## Solution

```java
public int maxTurbulenceSize(int[] A) {
    int ans = 1, N = A.length;
    int anchor = 0;
    
    for (int i = 1; i < N; i++) {
        int c1 = compare(A[i - 1], A[i]);
        if (i == N - 1 || c1 * compare(A[i], A[i + 1]) != -1) {
            ans = Math.max(ans, i - anchor + 1);
            anchor = i;
        }
    }
    return ans;
}
```

**private helper method**

```java
private int compare(int a, int b) {
    return Integer.compare(a, b);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/longest-turbulent-subarray/