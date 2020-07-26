# [11. Container With Most Water][title]

## Problem Description

Detail instruction can be found [here][title].

**Example:**

```
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
```

## Solution

**Approach 1: Brute Force (AC)**

```java
public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        for (int j = i; j < height.length; j++) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);
        }
    }
    return maxArea;
}
```

**Approach 2: Two pointers**

```java
public int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0, right = height.length - 1;
    
    while (left < right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(area, maxArea);
        
        if (height[left] < height[right])
            left++;
        else
            right--;
    }
    
    return maxArea;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/container-with-most-water/