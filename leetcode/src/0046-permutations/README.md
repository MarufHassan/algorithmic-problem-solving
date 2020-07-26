# [46. Permutations][title]

## Problem Description

Given a collection of distinct integers, return all possible permutations.

Detailed description can be found [here][title].

**Example 1:**

```
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## Solution

```java
public List<List<Integer>> permute(int[] nums) {
    permute(nums, 0, nums.length - 1);
    return collections;
}

private void permute(int[] nums, int left, int right) {
    if (left == right) {
        collections.add(asList(nums)); return;
    }
    for (int i = left; i <= right; i++) {
        swap(nums, i, left);
        permute(nums, left + 1, right);
        swap(nums, i, left);
    }
}
```

**private helper methods**

```java
private List<Integer> asList(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int v : nums) {
        list.add(v);
    }
    return list;
}

private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/permutations/