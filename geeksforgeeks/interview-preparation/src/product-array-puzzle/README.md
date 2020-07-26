# [Product array puzzle][title]

## Problem Description

Given an array A of size N, construct a Product Array P (of same size) such that P is equal to the product of all the elements of A except A[i].

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5
    10 3 5 6 2
    2
    12 20
Output
	180 600 360 300 900
    20 12
```

## Solution

```java
public static long[] products(int[] a) {
    int n = a.length;
    long product = 1;
    for (int i = 0; i < n; i++) {
        product *= a[i];
    }
    long[] ans = new long[n];
    for (int i = 0; i < n; i++) {
        ans[i] = product / a[i];
    }
    return ans;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/product-array-puzzle/0/