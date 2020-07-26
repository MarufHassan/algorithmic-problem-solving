# [747. Largest Number At Least Twice of Others][title]

## Problem Description

In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

**Example 1:**

```
Input: nums = [3, 6, 1, 0]
Output: 1

Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
```

**Example 2:**

```
Input: nums = [1, 2, 3, 4]
Output: -1

Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
```

## Solution

```java
public int dominantIndex(int[] nums) {
    int max = 0;
    
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > nums[max])
            max = i;
    }
    for (int n : nums) {
        if (n == nums[max]) continue;
        if (n * 2 > nums[max])
            return -1;
    }
    return max;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/largest-number-at-least-twice-of-others/