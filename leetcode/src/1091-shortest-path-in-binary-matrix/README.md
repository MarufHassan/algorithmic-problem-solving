# [1091. Shortest Path in Binary Matrix][title]

## Problem Description

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

**Example 1:**

```
Input: [[0,1],[1,0]]
Output: 2
```

**Example 2:**

```
Input: [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
```

## Solution

```java
public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length;
    
    if (grid[0][0] == 1)    return -1;
    
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0});
    grid[0][0] = 1;
    
    int res = 0;
    
    while (!q.isEmpty()) {
        for (int i = q.size(); i > 0; i--) {
            int[] curr = q.poll();
            int currX = curr[0], currY = curr[1];
            if (currX == m - 1 && currY == m - 1)
                return res + 1;
            
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j == 0 && k == 0) continue;
                    int nextX = currX + j;
                    int nextY = currY + k;
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= m || grid[nextX][nextY] == 1)
                        continue;

                    q.add(new int[] {nextX, nextY});
                    grid[nextX][nextY] = 1;
                    
                }
            }
        }
        res++;
    }
    return -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/shortest-path-in-binary-matrix/