# [2D Array - DS][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 2 4 4 0
        0 0 0 2 0 0
        0 0 1 2 4 0
    Output:
        19
```

## Solution

```java
static int hourglassSum(int[][] arr) {
    int m = arr.length, n = arr[0].length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < m - 2; i++) {
        for (int j = 0; j < n - 2; j++) {
            int sum = sum(arr, i, j);
            max = Math.max(max, sum);
        }
    }
    return max;
}
```

**Helper Method**

```java
static int sum(int[][] arr, int i, int j) {
    int sum = 0;
    sum += (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
    sum += (arr[i + 1][j + 1]);
    sum += (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
    return sum;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/2d-array/problem