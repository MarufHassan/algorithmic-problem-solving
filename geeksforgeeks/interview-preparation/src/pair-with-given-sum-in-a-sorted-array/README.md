# [Pair with given sum in a sorted array][title]

## Problem Description

You are given an array A of size N. You need to find all pairs in the array that sum to a number K. If no such pair exists then output will be -1. The elements of the array are distinct and are in sorted order.
Note: (a,b) and (b,a) are considered same. Also, an element cannot pair with itself, i.e., (a,a) is invalid.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    7
    1 2 3 4 5 6 7
    98
    7
    1 2 3 4 5 6 7
    8
Output
	-1
    1 7 8
    2 6 8
    3 5 8
```

## Solution

```java
public static List<int[]> findPair(int[] a, int k) {
    List<int[]> pairs = new ArrayList<>();
    int n = a.length;
    int lo = 0, hi = n - 1;
    while (lo < hi) {
        int sum = a[lo] + a[hi];
        if      (sum > k)    hi--;
        else if (sum < k)    lo++;
        else {
            pairs.add(new int[] {a[lo], a[hi]});
            lo++;
            hi--;
        }
    }
    return pairs;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array/0/