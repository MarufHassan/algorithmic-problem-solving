# [Find duplicates in an array][title]

## Problem Description

Given an array A[], Your task is to complete the function printDuplicates which prints the duplicate elements of the given array. If no duplicate element is found  print -1.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    4
    0 3 1 2
    5
    2 3 1 2 3 
Output
	-1
    2 3 
```

## Solution

```java
public void printDuplicates(int arr[], int n) {
    boolean flag = false;
    for (int i = 0; i < n; i++) {
        int idx = arr[i] % n;
        arr[idx] += n;
        if (arr[idx] / n == 2) {
            System.out.print(idx + " ");
            flag = true;
        }
    }
    if (!flag)
        System.out.print(-1);
}
```

## Test

Compile with `javac Duplicates.java` and run with `java Duplicates`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1/