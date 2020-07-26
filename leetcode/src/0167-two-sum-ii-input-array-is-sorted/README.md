# [167. Two Sum II - Input array is sorted][title]

## Problem Description

Detail instruction can be found [here][title].

**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

## Solution

**Approach 1: Two Pointers**

```java
public int[] twoSum(int[] numbers, int target) {
    int lo = 0, hi = numbers.length - 1;
    
    while (lo < hi) {
        int sum = numbers[lo] + numbers[hi];
        if (sum < target) lo++;
        else if (sum > target) hi--; 
        else
            return new int[] {lo + 1, hi + 1};
    }
    return null;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/