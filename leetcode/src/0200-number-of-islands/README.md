# [200. Number of Islands][title]

## Problem Description

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Solution

**Approach 1: Depth First Search**

```java
private static final int[] dx = {+1, 0, -1, 0};
private static final int[] dy = {0, +1, 0, -1};

private int R, C;

public int numIslands(char[][] grid) {
    if (grid.length == 0)   return 0;
    
    R = grid.length; C = grid[0].length;
    
    int island = 0;
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (grid[r][c] == '1') {
                dfs(grid, r, c);
                island++;
            }
        }
    }
    return island;
}
```

**private helper methods**

```java
private void dfs(char[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= R || col >= C || grid[row][col] != '1')
        return;
    grid[row][col] = '0';
    for (int i = 0; i < 4; i++) {
        dfs(grid, row + dy[i], col + dx[i]);
    }
}
```

**Approach 2: Breadth First Search**

```java
private static final int[] dx = {+1, 0, -1, 0};
private static final int[] dy = {0, +1, 0, -1};

private int R, C;

public int numIslands(char[][] grid) {
    if (grid.length == 0)   return 0;
    
    R = grid.length; C = grid[0].length;
    
    int island = 0;
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (grid[r][c] == '1') {
                bfs(grid, r, c);
                island++;
            }
        }
    }
    return island;
}
```

**private helper methods**

```java
private void bfs(char[][] grid, int row, int col) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {row, col});
    
    while (!q.isEmpty()) {
        int[] v = q.remove();
        for (int i = 0; i < 4; i++) {
            int nr = v[0] + dy[i];
            int nc = v[1] + dx[i];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || grid[nr][nc] == '0') continue;
            grid[nr][nc] = '0';
            q.add(new int[] {nr, nc});
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/network-delay-time/