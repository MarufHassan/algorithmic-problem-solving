# [217. Contains Duplicate][title]

## Problem Description

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**

```
Input: [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

## Solution

**Approach 1: Hash Table**

```java
public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) {
        freq.put(n, freq.getOrDefault(n, 0) + 1);
        if (freq.get(n) > 1)
            return true;
    }
    return false;
}
```

**Approach 2: Sorting**

```java
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i - 1])
            return true;
    }
    return false;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/contains-duplicate