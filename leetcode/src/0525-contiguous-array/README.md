# [525. Contiguous Array][title]

## Problem Description

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

**Example 1:**

```
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
```

**Example 2:**

```
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
```

## Solution

```java
public int findMaxLength(int[] nums) {
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, - 1);
    
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        count += (nums[i] == 0 ? -1 : 1);
        map.putIfAbsent(count, i);
        ans = Math.max(ans, i - map.get(count));
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/contiguous-array/