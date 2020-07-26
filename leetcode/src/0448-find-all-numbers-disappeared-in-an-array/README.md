# [448. Find All Numbers Disappeared in an Array][title]

## Problem Description

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

**Example 1:**

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

## Solution


```java
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    
    for (int i = 0; i < nums.length; i++) {
        int elements = Math.abs(nums[i]);
        if (nums[elements - 1] > 0)
            nums[elements - 1] = -nums[elements - 1];
    }
    
    for (int i = 1; i <= nums.length; i++) {
        if (nums[i - 1] > 0)
            res.add(i);
    }
    return res;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/