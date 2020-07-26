# [90. Subsets II][title]

## Problem Description

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Detailed description can be found [here][title].

**Example:**

```
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

## Solution

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> powerset = new ArrayList<>();
    Arrays.sort(nums);
    find(nums, 0, new ArrayList<>(), powerset);
    return powerset;
}

private void find(int[] nums, int start, List<Integer> chosen, List<List<Integer>> powerset) {
    powerset.add(new ArrayList<>(chosen));
    for (int i = start; i != nums.length; i++) {
        if (i == start || nums[i] != nums[i - 1]) {
            chosen.add(nums[i]);
            find(nums, i + 1, chosen, powerset);
            chosen.remove(chosen.size() - 1);
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/subsets-ii/