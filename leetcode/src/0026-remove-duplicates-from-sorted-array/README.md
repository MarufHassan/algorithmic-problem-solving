# [26. Remove Duplicates from Sorted Array][title]

## Problem Description

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Detailed description can be found [here][title].

**Example 1:**

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```

## Solution

```java
public int removeDuplicates(int[] nums) {
    int i = 0, j = i + 1;
    while (j < nums.length) {
        if (nums[i] != nums[j])
            nums[++i] = nums[j];
        j++;
    }
    return i + 1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array/