# [Count Smaller elements][title]

## Problem Description

Given an array A of positive integers. Count number of smaller elements on right side of each array.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    7
    12 1 2 3 0 11 4
    5
    1 2 3 4 5
Output
	6 1 1 1 0 1 0
    0 0 0 0 0
```

## Solution

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    long[] a = new long[1000000];
    while (t-- > 0) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i])
                    count++;
            }
            out.print(count + " ");
        }
        out.println();
    }
    out.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/count-smaller-elements/0/