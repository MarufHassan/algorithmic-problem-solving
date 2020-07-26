# [994. Rotting Oranges][title]

## Problem Description

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Detailed description can be found [here][title].

**Example 1:**

```
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

**Example 2:**

```
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1

Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
```

**Example 3:**

```
Input: [[0,2]]
Output: 0

Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
```

## Solution

```java
public int orangesRotting(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    
    Queue<int[]> q = new LinkedList<>();
    
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c] == ROTTEN) {
                q.add(new int[] {r, c});
            }
        }
    }
    
    int minute = 0;
    int[][] distTo = new int[rows][cols];
    
    while (!q.isEmpty()) {
        int[] v = q.poll();
        for (int i = 0; i < 4; i++) {
            int[] w = new int[2];
            w[0] = v[0] + dy[i];
            w[1] = v[1] + dx[i];
            if (w[0] < 0 || w[0] >= rows || w[1] < 0 || w[1] >= cols)
                continue;
            if (grid[w[0]][w[1]] == FRESH) {
                q.add(w);
                grid[w[0]][w[1]] = ROTTEN;
                distTo[w[0]][w[1]] = distTo[v[0]][v[1]] + 1;
                minute = distTo[w[0]][w[1]];
            }
        }
    }
    
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c] == FRESH) {
                return -1;
            }
        }
    }
    
    return minute;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/rotting-oranges/