# [1018. Binary Prefix Divisible By 5][title]

## Problem Description

Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

**Example 1:**

```
Input: [0,1,1]
Output: [true,false,false]

Explanation: 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
```

**Example 2:**

```
Input: [1,1,1]
Output: [false,false,false]
```

**Example 3:**

```
Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]
```

**Example 4:**

```
Input: [1,1,1,0,1]
Output: [false,false,false,false,false]
```

## Solution

```java
public List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> ans = new ArrayList<>();
    int n = 0;
    for (int d : A) {
        n = (n * 2 + d) % 5;
        ans.add(n == 0);
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-prefix-divisible-by-5/