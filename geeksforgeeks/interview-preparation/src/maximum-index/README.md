# [Maximum Index][title]

## Problem Description

Given an array A of positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Detailed description can be found [here][title]

**Example:**

```
Input
	1
    9
    34 8 10 3 2 80 30 33 1
Output
	6
```

## Solution

```java
public static int maxWidthRamp(int[] A) {
    int n = A.length;
    Integer[] index = new Integer[n];
    
    for (int i = 0; i < n; i++) {
        index[i] = i;
    }
    
    Arrays.sort(index, new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(A[i1], A[i2]);
        }
    });
    
    int m = n, max = 0;
    for (int i : index) {
        max = Math.max(i - m, max);
        m = Math.min(i, m);
    }
    
    return max;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/maximum-index/0/