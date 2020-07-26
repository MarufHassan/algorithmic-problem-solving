# [934. Shortest Bridge][title]

## Problem Description

In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Detailed description can be found [here][title].

**Example 1:**

```
Input: [[0,1],[1,0]]
Output: 1
```

**Example 2:**

```
Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
```

**Example 3:**

```
Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
```

## Solution

```java
public int shortestBridge(int[][] A) {
    R = A.length; C = A[0].length;
    
    dfs(A);
    
    return bfs(A);
}
```

**depth first search**

```java
private void dfs(int[][] A) {
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (A[r][c] == 1) {
                dfs(A, r, c);
                return;
            }
        }
    }
}

private void dfs(int[][] A, int row, int col) {
    if (row < 0 || row >= R || col < 0 || col >= C || A[row][col] != 1)
        return;
    
    A[row][col] += 1;
    for (int i = 0; i < 4; i++) {
        dfs(A, row + dy[i], col + dx[i]);
    }
}
```

**breadth first search**

```java
private int bfs(int[][] A) {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] marked = new boolean[R][C];
    
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (A[r][c] == 2) {
                q.add(new int[] {r, c});
                marked[r][c] = true;
            }
        }
    }
    
    int distance = 0;

    while (!q.isEmpty()) {
        int size = q.size();
        for (int s = 1; s <= size; s++) {
            int[] v = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = v[0] + dy[i];
                int nc = v[1] + dx[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;
                if (A[nr][nc] == 1)
                    return distance;
                if (!marked[nr][nc]) {
                    marked[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        distance++;
    }
    return -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/shortest-bridge/