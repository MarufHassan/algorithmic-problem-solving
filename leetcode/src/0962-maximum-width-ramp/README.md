# [962. Maximum Width Ramp][title]

## Problem Description

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [6,0,8,2,1,5]
Output: 4

Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
```

**Example 2:**

```
Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7

Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
```

## Solution

```java
public int maxWidthRamp(int[] A) {
    int n = A.length;
    Integer[] index = new Integer[n];
    
    for (int i = 0; i < n; i++) {
        index[i] = i;
    }
    
    Arrays.sort(index, new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(A[i1], A[i2]);
        }
    });
    
    int nextGreatest = index[n - 1], max = 0;
    for (int i = n - 2; i >= 0; i--) {
        nextGreatest = Math.max(nextGreatest, index[i]);
        max = Math.max(nextGreatest - index[i], max);
    }
    
    return max;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/maximum-width-ramp/