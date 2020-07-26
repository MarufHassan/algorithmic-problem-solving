# [852. Peak Index in a Mountain Array][title]

## Problem Description

Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

**Example 1:**

```
Input: [0,1,0]
Output: 1
```

**Example 2:**

```
Input: [0,2,1,0]
Output: 1
```

## Solution

**Approach 1: Binary Search**

```java
public int peakIndexInMountainArray(int[] A) {
    int lo = 0, hi = A.length - 1;
    
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (A[mid] < A[mid + 1])
            lo = mid + 1;
        else
            hi = mid;
    }
    return lo;
}
```

**Approach 2: Two Pointers**

```java
public int peakIndexInMountainArray(int[] A) {
    int lo = 0, hi = A.length - 1;
    
    while (lo < hi) {
        if (A[lo] < A[lo + 1]) lo++;
        if (A[hi] < A[hi - 1]) hi--;
    }
    return lo;
}
```

**Approach 3: Linear Scan**

```java
public int peakIndexInMountainArray(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
        if (A[i] > A[i + 1])
            return i;
    }
    return -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/peak-index-in-a-mountain-array/