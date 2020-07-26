# [334. Increasing Triplet Subsequence][title]

## Problem Description

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [1,2,3,4,5]
Output: true
```

**Example 2:**

```
Input: [5,4,3,2,1]
Output: false
```

## Solution


```java
public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
    
    for (int val : nums) {
        if      (val <= small)  small   = val;
        else if (val < big)     big     = val;
        else if (val > big)     return true;
    }
    return false;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/increasing-triplet-subsequence/