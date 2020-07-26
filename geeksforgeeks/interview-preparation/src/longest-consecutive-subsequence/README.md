# [Longest Consecutive Subsequence][title]

## Problem Description

Given an array A of integers. The task is to complete the function which returns an integer denoting the length of the longest sub-sequence such that elements in the sub-sequence are consecutive integers, the consecutive numbers can be in any order.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    7
    1 9 3 10 4 20 2
    11
    36 41 56 35 44 33 34 92 43 32 42
Output
	4
    5
```

## Solution

```java
int findLongestConseqSubseq(int a[], int n){
    Arrays.sort(a);
    int longest = 1, count = 1;
    for (int i = 1; i < n; i++) {
        if (a[i] - a[i - 1] == 0)
            continue;
        if (a[i] - a[i - 1] == 1)
            count++;
        else {
            longest = Math.max(longest, count);
            count = 1;
        }
    }
    return Math.max(longest, count);
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence/1/