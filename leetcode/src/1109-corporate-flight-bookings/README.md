# [1109. Corporate Flight Bookings][title]

## Problem Description

There are n flights, and they are labeled from 1 to n.

We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.

Return an array answer of length n, representing the number of seats booked on each flight in order of their label.

**Example 1:**

```
Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
```

## Solution

```java
public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] ans = new int[n];
    int lo, hi, val;
    for (int[] booking : bookings) {
        lo = booking[0] - 1; hi = booking[1] - 1;
        val = booking[2];
        
        ans[lo] += val;
        if (hi != n - 1)
            ans[hi + 1] -= val;
    }
    
    for (int i = 1; i < n; i++) 
        ans[i] += ans[i - 1]; 
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/corporate-flight-bookings/