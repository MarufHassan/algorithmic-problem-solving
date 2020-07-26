# [219. Contains Duplicate II][title]

## Problem Description

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

**Example 1:**

```
Input: nums = [1,2,3,1], k = 3
Output: true
```

**Example 2:**

```
Input: nums = [1,0,1,1], k = 1
Output: true
```

**Example 3:**

```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```

## Solution


```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> index = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        if (index.containsKey(nums[i])) {
            int idx = index.get(nums[i]);
            if (i - idx <= k)
                return true;
            
        }
        index.put(nums[i], i);
    }
    return false;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/contains-duplicate-ii/