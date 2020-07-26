# [442. Find All Duplicates in an Array][title]

## Problem Description

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

**Example 1:**

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
```

## Solution

**Approach 1:**

```java
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    
    for (int i = 0; i < nums.length; i++) {
        int val = Math.abs(nums[i]);
        if (nums[val - 1] < 0)
            ans.add(val);
        else
            nums[val - 1] = -nums[val - 1];
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-all-duplicates-in-an-array/