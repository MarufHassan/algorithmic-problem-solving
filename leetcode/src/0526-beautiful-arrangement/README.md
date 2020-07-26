# [526. Beautiful Arrangement][title]

## Problem Description

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
 

Now given N, how many beautiful arrangements can you construct?

Detailed description can be found [here][title].

**Example 1:**

```
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
```

## Solution

**Approach 1: Brute Force (TLE)**

```java
public int countArrangement(int N) {
    int[] nums = new int[N + 1];
    for (int i = 1; i <= N; i++) {
        nums[i] = i;
    }
    count = 0;
    permute(nums, 1);
    
    return count;
}

private void permute(int[] nums, int offset) {
    if (offset >= nums.length) {
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] % i != 0 && i % nums[i] != 0) {
                break;
            }
        }
        if (i == nums.length)
            count++;
        return;
    }
    
    for (int i = offset; i < nums.length; i++) {
        swap(nums, i, offset);
        permute(nums, offset + 1);
        swap(nums, i, offset);
    }
}
```

**Approach 2: Better Brute Force (AC)**

```java
private void permute(int[] nums, int offset) {
    if (offset >= nums.length) {
        count++; return;
    }
    
    for (int i = offset; i < nums.length; i++) {
        swap(nums, i, offset);
        if (nums[offset] % offset == 0 || offset % nums[offset] == 0)
            permute(nums, offset + 1);
        swap(nums, i, offset);
    }
}
```

**private helper methods**

```java
private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/beautiful-arrangement/