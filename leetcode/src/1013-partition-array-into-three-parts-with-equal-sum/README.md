# [1013. Partition Array Into Three Parts With Equal Sum][title]

## Problem Description

Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

**Example 1:**

```
Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
```

**Example 2:**

```
Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
```

**Example 3:**

```
Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
```

## Solution

```java
public boolean canThreePartsEqualSum(int[] A) {
    int sum = 0;
    for (int v : A) {
        sum += v;
    }
    if (sum % 3 != 0)   return false;
    
    int count = 0, running = 0;
    for (int v : A) {
        running += v;
        if (running == sum / 3) {
            count++;
            running = 0;
        }
    }
    return count == 3;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/