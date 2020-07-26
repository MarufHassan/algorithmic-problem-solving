# [867. Transpose Matrix][title]

## Problem Description

Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

**Example 1:**

```
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
```

**Example 2:**

```
Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
```

## Solution

```java
public int[][] transpose(int[][] A) {
    int[][] t = new int[A[0].length][A.length];
    
    for (int i = 0; i < t.length; i++) {
        for (int j = 0; j < t[0].length; j++) {
            t[i][j] = A[j][i];
        }
    }
    
    return t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/transpose-matrix/