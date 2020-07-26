# [Wave Array][title]

## Problem Description

Given a sorted array A of non-repeating integers without duplicates. Sort the array into a wave-like array and return it. In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... (considering the increasing lexicographical order).

Detailed description can be found [here][title]

**Example:**

```
Input
	1
    5
    1 2 3 4 5
Output
	2 1 4 3 5
```

## Solution

```java
private static void makeWave(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i += 2) {
        int t = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = t;
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/wave-array/0/