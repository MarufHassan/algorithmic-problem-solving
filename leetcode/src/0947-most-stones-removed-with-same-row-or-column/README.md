# [947. Most Stones Removed with Same Row or Column][title]

## Problem Description

On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

**Example 1:**

```
Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
```

**Example 2:**

```
Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
```

**Example 3:**

```
Input: stones = [[0,0]]
Output: 0
```

## Solution

```java
public int removeStones(int[][] stones) {
    Set<int[]> visited = new HashSet<>();
    int island = 0;
    
    for (int[] v : stones) {
        if (!visited.contains(v)) {
            explore(stones, v, visited);
            island++;
        }
    }
    
    return stones.length - island;
}

private void explore(int[][] stones, int[] v, Set<int[]> visited) {
    if (visited.contains(v)) return;
    
    visited.add(v);
    for (int[] w : stones) {
        if (v[0] == w[0] && v[1] == w[1])   continue;
        if (v[0] == w[0] || v[1] == w[1]) {
            if (!visited.contains(w)) {
                explore(stones, w, visited);
            }
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/