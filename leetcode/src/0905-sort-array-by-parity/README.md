# [905. Sort Array By Parity][title]

## Problem Description

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```

## Solution

**Approach 1: Two pass**

```java
public int[] sortArrayByParity(int[] A) {
    int[] ans = new int[A.length];
    int ptr = 0;
    for (int val : A) {
        if (val % 2 == 0)
            ans[ptr++] = val;
    }
    for (int val : A) {
        if (val % 2 != 0)
            ans[ptr++] = val;
    }
    return ans;
}
```

**Approach 2: Two pointer**

```java
public int[] sortArrayByParity(int[] A) {
    int[] ans = new int[A.length];
    int left = 0, right = A.length - 1;
    for (int val : A) {
        if (val % 2 == 0)
            ans[left++] = val;
        else
            ans[right--] = val;
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/third-maximum-number/