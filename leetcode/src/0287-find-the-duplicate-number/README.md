# [287. Find the Duplicate Number][title]

## Problem Description

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

**Example 1:**

```
Input: [1,3,4,2,2]
Output: 2
```

**Example 2:**

```
Input: [3,1,3,4,2]
Output: 3
```

## Solution

**Approach 1: Binary Search**

```java
public int findDuplicate(int[] nums) {
    int lo = 1, hi = nums.length - 1;
    
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        int count = count(nums, mid);
        
        if (count <= mid)
            lo = mid + 1;
        else
            hi = mid;
    }
    return lo;
}
```

**private helper methods**

```java
private int count(int[] nums, int key) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= key)
            count++;
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-the-duplicate-number/