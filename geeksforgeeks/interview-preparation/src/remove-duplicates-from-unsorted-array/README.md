# [Remove Duplicates from unsorted array][title]

## Problem Description

Given an array of integers which may or may not contain duplicate elements. Your task is to print the array after removing duplicate elements, if present.

Detailed description can be found [here][title]

**Example:**

```
Input
	1
    6
    1 2 3 1 4 2
Output
	1 2 3 4
```

## Solution

**Approach 1: Brute Force**

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int[] a = new int[100];
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        for (int i = 0, k = 0; i < n; i++) {
            int val = in.nextInt();
            if (!contain(a, k, val)) {
                out.print(val + " ");
                a[k++] = val;
            }
        }
        out.println();
    }
    out.close();
}
```

**Helper Method**

```java
private static boolean contain(int[] a, int n, int val) {
    for (int i = n - 1; i >= 0; i--) {
        if (a[i] == val)
            return true;
    }
    return false;
}
```

**Approach 2: Hashing**

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        Set<Integer> sets = new LinkedHashSet<Integer>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            sets.add(in.nextInt());
        }
        for (int v : sets) {
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