# [53. Maximum Subarray][title]

## Problem Description

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Detail instruction can be found [here][title].

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

## Solution

**Approach 1: Dynamic Programming**

```java
public int maxSubArray(int[] nums) {
    if (nums.length <= 0) return 0;
    int n = nums.length;
    
    int prev = nums[0], curr;
    int max = nums[0];
    for (int i = 1; i < n; i++) {
        curr = Math.max(nums[i] + prev, nums[i]);
        max = Math.max(curr, max);
        prev = curr;
    }
    return max;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/maximum-subarray/