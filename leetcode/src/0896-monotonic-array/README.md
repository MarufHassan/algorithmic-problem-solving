# [896. Monotonic Array][title]

## Problem Description

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

**Example 1:**

```
Input: [1,2,2,3]
Output: true
```

**Example 2:**

```
Input: [6,5,4,4]
Output: true
```

## Solution

**Approach 1: Two pass**

```java
private boolean ascending(int[] A) {
    for (int i = 1; i < A.length; i++) {
        if (A[i] < A[i - 1])
            return false;
    }
    return true;
}

private boolean descending(int[] A) {
    for (int i = 1; i < A.length; i++) {
        if (A[i] > A[i - 1])
            return false;
    }
    return true;
}

public boolean isMonotonic(int[] A) {
    return ascending(A) || descending(A);
}
```

**Approach 2: One pass**

```java
public boolean isMonotonic(int[] A) {
    int store = 0;
    for (int i = 1; i < A.length; i++) {
        int cmp = Integer.compare(A[i], A[i - 1]);
        if (cmp != 0) {
            if (store == 0)
                store = cmp;
            else if (store != cmp)
                return false;
        }
    }
    return true;
}
```

**Approach 3: One pass**

```java
public boolean isMonotonic(int[] A) {
    boolean increasing = true;
    boolean decreasing = true;
    for (int i = 0; i < A.length - 1; ++i) {
        if (A[i] > A[i+1])
            increasing = false;
        if (A[i] < A[i+1])
            decreasing = false;
    }

    return increasing || decreasing;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/monotonic-array