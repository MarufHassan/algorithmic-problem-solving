# [1007. Minimum Domino Rotations For Equal Row][title]

## Problem Description

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

**Example 1:**

```
Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2

Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
```

**Example 2:**

```
Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
```

**Example 3:**

```
Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1

Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
```

## Solution

**Approach 1: Brute Force**

```java
public int minDominoRotations(int[] A, int[] B) {
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= 6; i++) {
        int rotation = findMinRotation(A, B, i);
        ans = Math.min(rotation, ans);
    }
    
    for (int i = 1; i <= 6; i++) {
        int rotation = findMinRotation(B, A, i);
        ans = Math.min(rotation, ans);
    }
    
    return ans == Integer.MAX_VALUE ? -1 : ans;
}
```

**Approach 2: Reduced Search Space**

```java
public int minDominoRotations(int[] A, int[] B) {
    int ans = Integer.MAX_VALUE;
    
    ans = Math.min(ans, findMinRotation(A, B, A[0]));
    ans = Math.min(ans, findMinRotation(A, B, B[0]));
    ans = Math.min(ans, findMinRotation(B, A, A[0]));
    ans = Math.min(ans, findMinRotation(B, A, B[0]));

    return ans == Integer.MAX_VALUE ? -1 : ans;
}
```

**private helper methods**

```java
private int findMinRotation(int[] A, int[] B, int v) {
    int rotation = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] == v) continue;
        if (B[i] == v)
            rotation++;
        else
            return Integer.MAX_VALUE; // large number
    }
    return rotation;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/