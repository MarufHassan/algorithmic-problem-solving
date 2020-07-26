# [75. Sort Colors][title]

## Problem Description

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

**Example 1:**

```
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

## Solution

**Approach 1: Counting Sort**

```java
public void sortColors(int[] nums) {
    int[] count = new int[3];
    int[] aux = Arrays.copyOf(nums, nums.length);
    
    for (int color : nums) {
        count[color]++;
    }
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }
    for (int i = 0; i < aux.length; i++) {
        nums[--count[aux[i]]] = aux[i];
    }
}
```

**Approach 2: Quick Sort 3-way partitioning**

```java
public void sortColors(int[] nums) {
    int lo = 0, hi = nums.length - 1, i = 0;
    
    while (i <= hi) {
        if      (nums[i] == 0) swap(nums, lo++, i++);
        else if (nums[i] == 2) swap(nums, i, hi--);
        else if (nums[i] == 1) i++;
    }
}
```

**private helper methods**

```java
private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/sort-colors/