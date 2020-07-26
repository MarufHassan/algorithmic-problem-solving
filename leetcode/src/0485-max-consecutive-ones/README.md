# [485. Max Consecutive Ones][title]

## Problem Description

Given a binary array, find the maximum number of consecutive 1s in this array.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [1,1,0,1,1,1]
Output: 3

Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
```

## Solution

```java
public int findMaxConsecutiveOnes(int[] nums) {
    int res = 0;
    for (int i = 0, j = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            j = i + 1;
        } else {
            res = Math.max(res, i - j + 1);
        }
    }
    return res;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/max-consecutive-ones/