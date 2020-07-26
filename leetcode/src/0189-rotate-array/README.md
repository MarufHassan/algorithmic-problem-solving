# [189. Rotate Array][title]

## Problem Description

Given an array, rotate the array to the right by k steps, where k is non-negative.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]

Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

## Solution

```java
public void rotate(int[] nums, int k) {
    k = k % nums.length;
    int sets = gcd(nums.length, k);
    
    for (int i = sets - 1; i >= 0; i--) {
        int j = i;
        int temp = nums[i];
        int step = (j - k) % nums.length;
        if (step < 0)   step += nums.length;
        while (step != i) {
            nums[j] = nums[step];
            j = step;
            step = (j - k) % nums.length;
            if (step < 0)   step += nums.length;
        }
        nums[j] = temp;
    }
}
```

**private helper method**

```java
private int gcd(int a, int b) {
    if (a == 0)
        return b;
    return gcd(b % a, a);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/rotate-array/