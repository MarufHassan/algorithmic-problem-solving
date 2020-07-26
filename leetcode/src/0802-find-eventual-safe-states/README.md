# [802. Find Eventual Safe States][title]

## Problem Description

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Detailed description can be found [here][title].

**Example 1:**

```
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]

Here is a diagram of the above graph.
```

## Solution

```java
private final static int WHITE = 0;
private final static int GRAY = 1;
private final static int BLACK = 2;

public List<Integer> eventualSafeNodes(int[][] graph) {
    int V = graph.length;
    int[] color = new int[V];
    
    List<Integer> res = new ArrayList<>();
    for (int v = 0; v < V; v++) {
        if (dfs(graph, v, color))
            res.add(v);
    }
    
    return res;
}
```

**private helper methods**

```java
private boolean dfs(int[][] graph, int node, int[] color) {
    if (color[node] != WHITE)
        return color[node] == BLACK;
    color[node] = GRAY;
    for (int adj : graph[node]) {
        if (!dfs(graph, adj, color))
            return false;
    }
    color[node] = BLACK;
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-eventual-safe-states/