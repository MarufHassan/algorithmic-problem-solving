# [463. Island Perimeter][title]

## Problem Description

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

**Example 1:**

```
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
```

## Solution

```java
public int islandPerimeter(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int count = 0;
    
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < m; c++) {
            if (grid[r][c] == 0) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1) {
                    count++;
                }
            }
        }
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/island-perimeter/