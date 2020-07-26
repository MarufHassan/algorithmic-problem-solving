# [88. Merge Sorted Array][title]

## Problem Description

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

**Example 1:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

## Solution

**Approach 1: Concise Solution**

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1, 0, m + n);
}
```

**Approach 2: Merge routine from merge sort**

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;
    
    int[] aux = new int[m + n];
    
    for (int k = 0; k < m + n; ) {
        if      (i >= m) aux[k++] = nums2[j++];
        else if (j >= n) aux[k++] = nums1[i++];
        else if (nums1[i] > nums2[j]) aux[k++] = nums2[j++];
        else    aux[k++] = nums1[i++];
    }
    System.arraycopy(aux, 0, nums1, 0, m + n);
}
```

**Approach 3: O(1) space**

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, val;
    
    for (int k = m + n - 1; k >= 0; k--) {
        if (i < 0)
            val = nums2[j--];
        else if (j < 0)
            val = nums1[i--];
        else if (nums1[i] > nums2[j])
            val = nums1[i--];
        else
            val = nums2[j--];
        nums1[k] = val;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/merge-sorted-array/