# [40. Combination Sum II][title]

## Problem Description

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

**Example 2:**

```
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
```

## Solution

```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    ans = new ArrayList<>();
    Arrays.sort(candidates);
    
    combinationSum2(candidates, target, 0, new ArrayList<>());
    
    return ans;
}

private void combinationSum2(int[] candidates, int target, int index, List<Integer> chosen) {
    if (target <= 0) {
        if (target == 0)
            ans.add(new ArrayList<>(chosen));
        return;
    }
    
    for (int i = index; i != candidates.length; i++) {
        if (i == index || candidates[i] != candidates[i - 1]) {
            chosen.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, chosen);
            chosen.remove(chosen.size() - 1);
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/combination-sum-ii/