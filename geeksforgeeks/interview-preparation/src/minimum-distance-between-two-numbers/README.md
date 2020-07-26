# [Minimum distance between two numbers][title]

## Problem Description

You are given an array A, of N elements. You need to find minimum distance between given two integers x and y.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    2
    1 2
    1 2
    7
    86 39 90 67 84 66 62 
    42 12
Output
	1
    -1
```

## Solution

```java
long minDist(Long arr[], long n, long x, long y) 
{
   long minDistance = n, xPtr = 2 * n, yPtr = 2 * n;
   for (int i = 0; i < n; i++) {
       if (arr[i] == x) {
           xPtr = i;
           minDistance = Math.min(minDistance, Math.abs(xPtr - yPtr));
       } else if (arr[i] == y) {
           yPtr = i;
           minDistance = Math.min(minDistance, Math.abs(xPtr - yPtr));
       }
   }
   return minDistance == n ? -1 : minDistance;
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/1/