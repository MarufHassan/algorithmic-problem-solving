# [Arrays: Left Rotation][title]

## Problem Description

Given an array _a_ of _n_ integers and a number, _d_, perform _d_ left rotations on the array. Return the updated array to be printed as a single line of space-separated integers. Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5 4
        1 2 3 4 5
    Output:
        5 1 2 3 4
```

## Solution

```java
static int[] rotLeft(int[] a, int d) {
    int n = a.length;
    int[] rotated = new int[n];

    for (int i = 0; i < n; i++) {
        int index = (i - d) % n;
        if (index < 0) index += n;
        rotated[index] = a[i];
    }
    return rotated;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/ctci-array-left-rotation