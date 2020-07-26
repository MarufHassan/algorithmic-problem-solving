# [78. Subsets][title]

## Problem Description

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Detailed description can be found [here][title].

**Example:**

```
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

## Solution

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> powerset = new ArrayList<>();
    find(nums, 0, new ArrayList<>(), powerset);
    return powerset;
}

private void find(int[] nums, int ptr, List<Integer> chosen, List<List<Integer>> powerset) {
    powerset.add(new ArrayList<>(chosen));
    for (int i = start; i != nums.length; i++) {
        chosen.add(nums[i]);
        find(nums, i + 1, chosen, powerset);
        chosen.remove(chosen.size() - 1);
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/subsets/