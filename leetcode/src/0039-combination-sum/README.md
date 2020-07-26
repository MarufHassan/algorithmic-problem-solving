# [39. Combination Sum][title]

## Problem Description

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

## Solution

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ans = new ArrayList<>();
    
    combinationSum(candidates, target, 0, new ArrayList<>());
    
    return ans;
}

private void combinationSum(int[] candidates, int target, int index, List<Integer> chosen) {
    if (target <= 0) {
        if (target == 0) {
            ans.add(new ArrayList<>(chosen));
        }
        return;
    }
    if (index >= candidates.length) return;
    
    int value = candidates[index];
    chosen.add(value);        
    combinationSum(candidates, target - value, index, chosen);
    
    chosen.remove(chosen.size() - 1);
    combinationSum(candidates, target, index + 1, chosen);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/combination-sum/