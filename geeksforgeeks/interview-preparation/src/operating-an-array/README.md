# [Operating an array][title]

## Problem Description

Given an array A of size N, your task is to do some operations, i.e., search an element, insert an element, and delete an element by completing the functions. Also, all functions should return a boolean value.

Detailed description can be found [here][title]

**Example:**

```
Input
	1
  5
  2 4 1 0 6
  1 2 2 0
Output
	1 1 1
```

## Solution

```java
public boolean searchEle(int a[], int x){
    for (int i = 0; i < a.length; i++) {
        if (a[i] == x)
            return true;
    }
    return false;
}
public boolean insertEle(int a[], int y, int yi) {
    int n = 0;
    for (int i = 0; i < 100; i++, n++) {
        if (a[i] == -1)
            break;
    }
    
    for (int i = n - 1; i >= yi; i--) {
        a[i + 1] = a[i];
    }
    a[yi] = y;
    return true;
}
public boolean deleteEle(int a[], int z){
    for (int i = 0; i < a.length; i++) {
        if (a[i] == z)  deleteAtIndex(a, i);
    }
    return true;
}

private void deleteAtIndex(int[] a, int idx) {
    for (int i = idx; i < a.length - 1; i++) {
        a[i] = a[i + 1];
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/operating-an-array/1/