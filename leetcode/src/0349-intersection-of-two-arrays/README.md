# [350. Intersection of Two Arrays II][title]

## Problem Description

Given two arrays, write a function to compute their intersection.

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```

**Example 2:**

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
```

## Solution

**Approach 1: Hashing**

```java
public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int v : nums2) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }
    
    int[] ans = new int[nums1.length];
    int idx = 0;
    for (int v : nums1) {
        int val = map.getOrDefault(v, -1);
        if (val > 0) {
            ans[idx++] = v;
            map.put(v, val - 1);
        }
    }
    return Arrays.copyOf(ans, idx);
}
```

**Approach 2: Sort, Two Pointers**

```java
public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    int[] ans = new int[nums1.length];
    
    int i = 0, j = 0, idx = 0;
    while (i < nums1.length && j < nums2.length) {
        if      (nums1[i] < nums2[j]) i++;
        else if (nums1[i] > nums2[j]) j++;
        else {
            ans[idx++] = nums1[i];
            i++; j++;
        }
    }
    
    return Arrays.copyOf(ans, idx);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/intersection-of-two-arrays-ii