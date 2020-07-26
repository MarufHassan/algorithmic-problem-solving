# [Ups and Downs][title]

## Problem Description

Given an array A of N integers. The task is to count Ups and Downs formed in the array.
Up: A point which is at higher than its neighbours.
Down: A point which is deeper than its neighbours.

Detailed description can be found [here][title]

**Example:**

```
Input
	1
    9
    1 2 3 4 5 6 5 8 2
Output
	2 1
```

## Solution


```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ups = 0, downs = 0;
        int i = 1;
        while (i + 1 < n) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1])
                ups++;
            if (a[i] < a[i - 1] && a[i] < a[i + 1])
                downs++;
            i++;
        }
        System.out.println(ups + " " + downs);
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/contest-problem/ups-and-downs/0