# [1004. Max Consecutive Ones III][title]

## Problem Description

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Detail instruction can be found [here][title].

**Example 1:**

```
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6

Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
```

**Example 2:**

```
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10

Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
```

## Solution

```java
public int longestOnes(int[] A, int K) {
    int res = 0, flip = 0;
    for (int i = 0, j = 0; i < A.length; i++) {
        if (A[i] == 0)
            flip++;
        if (flip > K) {
            while (A[j++] == 1);
            flip--;
        }
        res = Math.max(res, i - j + 1);
    }
    return res;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/max-consecutive-ones-iii/