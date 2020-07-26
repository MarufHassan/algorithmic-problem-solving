# [414. Third Maximum Number][title]

## Problem Description

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
```

**Example 2:**

```
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```

**Example 3:**

```
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```

## Solution

```java
public int thirdMax(int[] nums) {
    Integer max1 = null, max2 = null, max3 = null;
    for (Integer val : nums) {
        if (val.equals(max1) || val.equals(max2) || val.equals(max3))
            continue;
        if (max1 == null || val > max1) {
            max3 = max2;
            max2 = max1;
            max1 = val;
        } else if (max2 == null || val > max2) {
            max3 = max2;
            max2 = val;
        } else if (max3 == null || val > max3) {
            max3 = val;
        }
    }
    if (max3 == null)
        return max1;
    return max3;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/third-maximum-number/