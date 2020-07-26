# [945. Minimum Increment to Make Array Unique][title]

## Problem Description
Given an array of integers A, a move consists of choosing any `A[i]`, and incrementing it by 1.

Return the least number of moves to make every value in A unique

**Example 1:**

```
Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
```

**Example 2:**

```
Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
```

## Solution


```java
public int minIncrementForUnique(int[] A) {
    if (A.length <= 0)  return 0;

    Arrays.sort(A);
    int sum = 0, distinctSum = 0;

    for (int i = 0; i < A.length; i++) {
        sum += A[i];
    }

    int prev = A[0];
    distinctSum = A[0];
    for (int i = 1; i < A.length; i++) {
        if (A[i] <= prev) {
            prev += 1;
            distinctSum += prev;
        } else {
            distinctSum += A[i];
            prev = A[i];
        }
    }
    return distinctSum - sum;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public int minIncrementForUnique(int[] A) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = new int[] {1, 2, 2};
        assert s.minIncrementForUnique(A) == 1;

        A = new int[] {3, 2, 1, 2, 1, 7};
        assert s.minIncrementForUnique(A) == 6;

        A = new int[] {};
        assert s.minIncrementForUnique(A) == 0;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-increment-to-make-array-unique/