# [785. Is Graph Bipartite?][title]

## Problem Description

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Detailed description can be found [here][title].

**Example 1:**

```
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
```

**Example 2:**

```
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
```

## Solution

**Approach 1: Breadth First Search**

```java
public boolean isBipartite(int[][] graph) {
    int V = graph.length;
    int[] color = new int[V];
    Arrays.fill(color, -1);
    
    for (int i = 0; i < V; i++) {
        if (graph[i].length == 0 || color[i] != -1)
            continue;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = RED;

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : graph[v]) {
                if (color[w] == -1) {
                    q.add(w);
                    color[w] = (color[v] == RED) ? BLUE : RED;
                } else if (color[v] == color[w])
                    return false;
            }
        }
    }
    
    return true;
}
```

**Approach 2: Depth First Search**

```java
public boolean isBipartite(int[][] graph) {
    int V = graph.length;
    boolean[] visited = new boolean[V];
    boolean[] color = new boolean[V];
    
    for (int v = 0; v < V; v++) {
        if (!visited[v] && !dfs(graph, v, visited, color)) {
            return false;
        }
    }
    return true;
}

private boolean dfs(int[][] graph, int s, boolean[] visited, boolean[] color) {
    if (visited[s]) return true;
    
    visited[s] = true;
    for (int w : graph[s]) {
        if (!visited[w]) {
            color[w] = !color[s];
            if (!dfs(graph, w, visited, color))
                return false;
        } else if (color[s] == color[w])
            return false;
    }
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/is-graph-bipartite/