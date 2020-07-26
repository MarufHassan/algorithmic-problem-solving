# [1089. Duplicate Zeros][title]

## Problem Description

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

**Example 1:**

```
Input: [1,0,2,3,0,4,5,0]
Output: null

Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
```

**Example 2:**

```
Input: [1,2,3]
Output: null

Explanation: After calling your function, the input array is modified to: [1,2,3]
```

## Solution

**Approach 1: Using extra memory**

```java
public void duplicateZeros(int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int i : arr) {
        if (i == 0) {
            list.add(0);
        }
        list.add(i);
    }
    for (int i = 0; i < arr.length; i++) {
        arr[i] = list.get(i);
    }
}
```

**Approach 2: In place**

```java
public void duplicateZeros(int[] arr) {
    int n = arr.length, i, j;
    for (i = 0, j = 0; i < n; i++, j++) {
        if (arr[i] == 0) j++;
    }
    for (i = i - 1; i >= 0; i--) {
        if (--j < n)    arr[j] = arr[i];
        
        if (arr[i] == 0 && --j < n)
            arr[j] = 0;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/duplicate-zeros/