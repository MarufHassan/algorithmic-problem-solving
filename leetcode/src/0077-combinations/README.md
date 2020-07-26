# [77. Combinations][title]

## Problem Description

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Detailed description can be found [here][title].

**Example:**

```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

## Solution

**Approach 1: Brute Force**

```java
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> powerset = new ArrayList<>();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
        nums[i] = i + 1;
    }
    
    find(nums, k, 0, new ArrayList<>(), powerset);
    return powerset;
}

private void find(int[] nums, int k, int start, List<Integer> chosen, List<List<Integer>> powerset) {
    if (chosen.size() == k)
        powerset.add(new ArrayList<>(chosen));
    
    for (int i = start; i != nums.length; i++) {
        chosen.add(nums[i]);
        find(nums, k, i + 1, chosen, powerset);
        chosen.remove(chosen.size() - 1);
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/subsets-ii/