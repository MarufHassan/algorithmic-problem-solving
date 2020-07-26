# [695. Max Area of Island][title]

## Problem Description

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

**Example 1:**

```
Input:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
```

**Example 2:**

```
Input:
[[0,0,0,0,0,0,0,0]]

Output:
0
```

## Solution

```java
public int maxAreaOfIsland(int[][] grid) {
    int ans = 0;
    
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            count = 0;
            if (grid[r][c] == 1)
                dfs(grid, r, c);
            ans = Math.max(ans, count);
        }
    }
    
    return ans;
}
```

**private helper methods**

```java
private void dfs(int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
        return;
    
    count += 1;
    grid[row][col] = 0;
    for (int i = 0; i < 4; i++) {
        int newRow = row + directionY[i];
        int newCol = col + directionX[i];
        dfs(grid, newRow, newCol);
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/max-area-of-island/