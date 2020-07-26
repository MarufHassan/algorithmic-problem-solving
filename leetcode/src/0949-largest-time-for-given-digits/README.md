# [949. Largest Time for Given Digits][title]

## Problem Description
Given an array of 4 digits, return the largest 24 hour time that can be made. Detailed description can be found [here][title]

**Example 1:**

```
Input: [1,2,3,4]
Output: "23:41"
```

**Example 2:**

```
Input: [5,5,5,5]
Output: ""
```

## Solution


```java
public String largestTimeFromDigits(int[] A) {
    int[][] perm = new int[][] {
        {A[0], A[1], A[2], A[3]},
        {A[0], A[2], A[1], A[3]},
        {A[0], A[3], A[1], A[2]},
        {A[1], A[2], A[0], A[3]},
        {A[1], A[3], A[0], A[2]},
        {A[2], A[3], A[0], A[1]}
    };
    
    int ans = -1;
    for (int i = 0; i < 6; i++) {
        int hour = best(perm[i][0], perm[i][1], 24);
        int minute = best(perm[i][2], perm[i][3], 60);
        int time = hour * 60 + minute;
        
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && time > ans) {
            ans = time;
        }
    }
    
    return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
}

private int best(int d1, int d2, int limit) {
    int n1 = d1 * 10 + d2;
    int n2 = d2 * 10 + d1;
    return Math.max(n1 < limit ? n1 : -1, n2 < limit ? n2 : -1);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/largest-time-for-given-digits/