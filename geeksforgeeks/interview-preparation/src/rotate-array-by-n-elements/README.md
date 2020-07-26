# [Rotate Array][title]

## Problem Description

Given an array of size N, rotate it by D elements. 

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5 2
    1 2 3 4 5 
    10 3
    2 4 6 8 10 12 14 16 18 20
Output
	3 4 5 1 2
    8 10 12 14 16 18 20 2 4 6
```

## Solution

**Approach 1: Brute Force (TLE)**

```java
public static void rotate(int[] a) {
    int t = a[0], n = a.length;
    for (int i = 1; i < n; i++) {
        a[i - 1] = a[i];
    }
    a[n - 1] = t;
}

public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = in.nextInt();
        for (int i = 1; i <= d; i++)
            rotate(a);
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }
    out.close();
}
```

**Approach 2: Linear time, linear space**

```java
public static int[] rotate(int[] a, int d) {
    int n = a.length;
    int[] aux = new int[n];
    for (int i = d; i < n; i++) {
        aux[i - d] = a[i];
    }
    for (int i = 0; i < d; i++) {
        aux[n - d + i] = a[i];
    }
    return aux;
}

public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = in.nextInt();
        for (int v : rotate(a, d)) {
            out.print(v + " ");
        }
        out.println();
    }
    out.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/remove-duplicates-from-unsorted-array/0/