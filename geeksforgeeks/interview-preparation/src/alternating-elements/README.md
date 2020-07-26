# [Alternating elements][title]

## Problem Description

Given two arrays A and B of size N and M. The task is to print the array elements of A and B alternatively, i.e, A[i], B[i], A[i+1], B[i+1] ... .

Detailed description can be found [here][title]

**Example:**

```
Input
	1
    2 3
    1 3
    2 4 5
Output
	1 2 3 4 5
```

## Solution

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < m + n; i++) {
            if (i < n) {
                out.print(a[i] + " ");
            }
            if (i < m) {
                out.print(b[i] + " ");
            }
        }
        out.println();
    }
    out.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/contest-problem/alternating-elements/0