# [42. Trapping Rain Water][title]

## Problem Description

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Detail instruction can be found [here][title].

**Example:**

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 
```

## Solution

**Approach 1: Brute Force**

```java
public int trap(int[] height) {
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
private int leftMax(int[] height, int start) {
    int max = start;
    for (int i = start - 1; i >= 0; i--) {
        if (height[i] > height[max])
            max = i;
    }
    return max;
}

private int rightMax(int[] height, int start) {
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

**Approach 3: Two Pointer**

```java
public int trap(int[] height) {
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

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/trapping-rain-water