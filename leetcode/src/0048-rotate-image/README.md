# [48. Rotate Image][title]

## Problem Description

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

**Example 1:**

```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

## Solution

**Approach 1: In-place**

```java
public void rotate(int[][] matrix) {
    int n = matrix.length;
    
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    
    for (int i = 0; i < n; i++) {
        reverse(matrix, i);
    }
}
```

**private helper methods**

```java
private void reverse(int[][] matrix, int row) {
    int n = matrix.length;
    
    for (int i = 0; i < n / 2; i++) {
        int temp = matrix[row][i];
        matrix[row][i] = matrix[row][n - i - 1];
        matrix[row][n - i - 1] = temp;
    }
}
```

**Approach 2: Allocate extra memory**

```java
public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] rotated = new int[n][n];
    
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j >= 0; j--) {
            rotated[i][n - j - 1] = matrix[j][i];
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = rotated[i][j];
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/rotate-image/