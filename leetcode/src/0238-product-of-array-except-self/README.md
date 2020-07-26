# [238. Product of Array Except Self][title]

## Problem Description

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Detailed description can be found [here][title].

**Example 1:**

```
Input:  [1,2,3,4]
Output: [24,12,8,6]
```

## Solution

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    if (n <= 0) return ans;
    
    ans[0] = 1;
    for (int i = 1; i < n; i++) {
        ans[i] = ans[i - 1] * nums[i - 1];
    }
    
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        ans[i] = right * ans[i];
        right *= nums[i];
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/product-of-array-except-self/