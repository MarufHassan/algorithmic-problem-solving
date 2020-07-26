# [Find minimum and maximum element in an array][title]

## Problem Description

Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    6
    3 2 1 56 10000 167
    5
    1 345 234 21 56789
Output
	1 10000
    1 56789
```

## Solution

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) 
            a[i] = in.nextLong();
        int min = minIndex(a);
        int max = maxIndex(a);
        System.out.print(a[min] + " " + a[max]);
        System.out.println();
    }
}
```

**Helper Method**

```java
private static int minIndex(long[] a) {
    int min = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] < a[min])
            min = i;
    }
    return min;
}

private static int maxIndex(long[] a) {
    int max = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] > a[max])
            max = i;
    }
    return max;
}
```


## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array/0/