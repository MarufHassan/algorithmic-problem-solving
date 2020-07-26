# [Trapping Rain Water][title]

## Problem Description

Given an array A of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
| |
|\_|
We can trap 2 units of water in the middle gap.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    4
    7 4 0 9
    3
    6 9 9
Output
	10
    0
```

## Solution

**Approach 1: Brute Force (TLE)**

```java
public static int trap(int[] height) {
    int amount = 0;
    for (int i = 1; i < height.length - 1; i++) {
        int leftMax = leftMax(height, i);
        int rightMax = rightMax(height, i);
        int level = Math.min(height[leftMax], height[rightMax]);
        amount += (level - height[i]);
    }
    return amount;
}
```

**private helper methods**

```java
private static int leftMax(int[] height, int start) {
    int max = start;
    for (int i = start - 1; i >= 0; i--) {
        if (height[i] > height[max])
            max = i;
    }
    return max;
}

private static int rightMax(int[] height, int start) {
    int max = start;
    for (int i = start + 1; i < height.length; i++) {
        if (height[i] > height[max])
            max = i;
    }
    return max;
}
```

**Approach 2: Dynamic Programming**

```java
public static int trap(int[] height) {
    if (height == null || height.length <= 0)
        return 0;
    int amount = 0;
    int[] leftMax = leftMax(height);
    int[] rightMax = rightMax(height);
    for (int i = 1; i < height.length - 1; i++) {
        int level = Math.min(leftMax[i], rightMax[i]);
        amount += (level - height[i]);
    }
    return amount;
}
```

**private helper methods**

```java
private static int[] leftMax(int[] height) {
    int n = height.length;        
    int[] left = new int[n];

    left[0] = height[0];
    for (int i = 1; i < n; i++) {
        left[i] = Math.max(left[i - 1], height[i]);
    }
    return left;
}

private static int[] rightMax(int[] height) {
    int n = height.length;
    int[] right = new int[n];

    right[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        right[i] = Math.max(right[i + 1], height[i]);
    }
    return right;
}
```

**Approach 3: Two Pointers**

```java
public static int trap(int[] height) {
    int amount = 0;
    
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax)
                leftMax = height[left];
            else
                amount += (leftMax - height[left]);
            left++;
        } else {
            if (height[right] >= rightMax)
                rightMax = height[right];
            else
                amount += (rightMax - height[right]);
            right--;
        }
    }
    
    return amount;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/trapping-rain-water/0/