# [283. Move Zeroes][title]

## Problem Description

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

**Example 1:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

## Solution


```java
public void moveZeroes(int[] nums) {
    int tracker = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[tracker++] = nums[i];
            nums[i] = 0;
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/move-zeroes/