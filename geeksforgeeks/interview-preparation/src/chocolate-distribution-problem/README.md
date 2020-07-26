# [Chocolate Distribution Problem][title]

## Problem Description

Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    8
    3 4 1 9 56 7 9 12
    5
    7
    7 3 2 4 9 12 56
    3
Output
	6
    2
```

## Solution

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        int m = in.nextInt();
        Arrays.sort(a);
        long min = Long.MAX_VALUE;
        for (int i = m - 1; i < n; i++) {
            min = Math.min(min, (a[i] - a[i - m + 1]));
        }
        System.out.println(min);
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0/