# [215. Kth Largest Element in an Array][title]

## Problem Description

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```

**Example 2:**

```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```

## Solution

```java
public int findKthLargest(int[] nums, int k) {
    int N = nums.length;
    build(nums, N);
    for (int i = 0; i < k - 1; i++) {
        extract(nums, N--);
    }
    return extract(nums, N);
}
```

**private helper method**

```java
private int extract(int[] nums, int N) {
    int max = nums[0];
    exch(nums, 0, N - 1);
    sink(nums, 0, N - 1);
    return max;
}

private void build(int[] nums, int N) {
    for (int k = nums.length / 2; k >= 0; k--) {
        sink(nums, k, N);
    }
}

private void sink(int[] nums, int k, int N) {
    while (2 * k + 1 < N) {
        int j = 2 * k + 1;
        if (j < N - 1 && nums[j + 1] > nums[j])
            j++;
        if (nums[k] >= nums[j])
            break;
        exch(nums, k, j);
        k = j;
    }
}

private void exch(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/kth-largest-element-in-an-array/