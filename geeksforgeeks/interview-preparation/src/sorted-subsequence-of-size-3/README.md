# [Sorted subsequence of size 3][title]

## Problem Description

Given an array A of N integers, Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector, if no such element is present then return the empty vector of size 0.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5
    1 2 1 1 3
    3
    1 1 3
Output
	1
    0
```

## Solution

```java
public static ArrayList find3Numbers(int[] a,int n) {
    int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int val = a[i];
        if      (val <= small)  small   = val;
        else if (val < big)     big     = val;
        else if (val > big) {
            ans.addAll(Arrays.asList(small, big, val));
            return ans;
        }
    }
    return ans;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/