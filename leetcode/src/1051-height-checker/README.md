# [1051. Height Checker][title]

## Problem Description

Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)

**Example 1:**

```
Input: [1,1,4,2,1,3]
Output: 3

Explanation: 
Students with heights 4, 3 and the last 1 are not standing in the right positions.
```

## Solution

```java
public int heightChecker(int[] heights) {
    int count = 0;
    
    int[] copy = Arrays.copyOf(heights, heights.length);
    Arrays.sort(copy);
    
    for (int i = 0; i < heights.length; i++) {
        if (heights[i] != copy[i])
            count++;
    }
    
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/height-checker/