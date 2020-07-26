# [34. Find First and Last Position of Element in Sorted Array][title]

## Problem Description

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Detail instruction can be found [here][title].

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

## Solution

**Approach 1: Binary Search**

```java
public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    int[] ans = {-1, -1};
    if (n == 0) return ans;
    
    // lower bound binary search
    int lo = 0, hi = n - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if      (target < nums[mid])        hi = mid - 1;
        else if (target > nums[mid])        lo = mid + 1;
        else {
            ans[0] = mid;   // first position
            hi = mid - 1;
        }
    }
    
    // upper bound binary search
    lo = 0; hi = n - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if      (target < nums[mid])        hi = mid - 1;
        else if (target > nums[mid])        lo = mid + 1;
        else {
            ans[1] = mid; // last position
            lo = mid + 1;
        }
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/container-with-most-water/