# [349. Intersection of Two Arrays][title]

## Problem Description

Given two arrays, write a function to compute their intersection.

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
```

**Example 2:**

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
```

## Solution

**Approach 1: Hashing**

```java
public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    
    for (int v : nums1) {
        set1.add(v);
    }
    for (int v : nums2) {
        set2.add(v);
    }
    
    set1.retainAll(set2);
    
    int[] ans = new int[set1.size()];
    int i = 0;
    for (int v : set1) {
        ans[i++] = v;
    }
    
    return ans;
}
```

**Approach 2: Sort, Binary Search, Two Pointers**

```java
public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    int[] ans = new int[nums1.length];
    int i = 0, idx = 0;
    while (i < nums1.length) {
        // skip duplicates
        while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
            i++;
        }
        if (contains(nums2, nums1[i]))
            ans[idx++] = nums1[i];
        i += 1;
    }
    return Arrays.copyOf(ans, idx);
}
```

**private helper method**

```java
private boolean contains(int[] num, int key) {
    int lo = 0, hi = num.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (key > num[mid])
            lo = mid + 1;
        else if (key < num[mid])
            hi = mid - 1;
        else
            return true;
    }
    return false;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/intersection-of-two-arrays/