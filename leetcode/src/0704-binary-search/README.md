# [704. Binary Search][title]

## Problem Description

Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.

**Example 1:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

## Solution

```java
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if      (target < nums[mid]) hi = mid - 1;
        else if (target > nums[mid]) lo = mid + 1;
        else                         return mid;
    }
    return -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-search/