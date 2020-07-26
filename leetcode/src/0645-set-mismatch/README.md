# [645. Set Mismatch][title]

## Problem Description

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

**Example 1:**

```
Input: nums = [1,2,2,4]
Output: [2,3]
```

## Solution

**Approach 1: Hashing**

```java
public int[] findErrorNums(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    int sum = 0, n = nums.length, dup = -1;
    
    for (int v : nums) {
        if (seen.contains(v))
            dup = v;
        else
            seen.add(v);
        sum += v;
    }
    int missing = (n * (n + 1) / 2) - (sum - dup);
    return new int[] {dup, missing};
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/set-mismatch/