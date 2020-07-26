# [1037. Valid Boomerang][title]

## Problem Description

A boomerang is a set of 3 points that are all distinct and not in a straight line.

Given a list of three points in the plane, return whether these points are a boomerang.

Detailed description can be found [here][title].

**Example 1:**

```
Input: [[1,1],[2,3],[3,2]]
Output: true
```

**Example 2:**

```
Input: [[1,1],[2,2],[3,3]]
Output: false
```

## Solution

```java
public boolean isBoomerang(int[][] p) {
      return p[0][0] * (p[1][1] - p[2][1]) + p[1][0] * (p[2][1] - p[0][1]) + p[2][0] * (p[0][1] - p[1][1]) != 0;
  }
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-boomerang/