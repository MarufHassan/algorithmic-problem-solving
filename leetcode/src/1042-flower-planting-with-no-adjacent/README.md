# [1042. Flower Planting With No Adjacent][title]

## Problem Description

You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

## Solution

**Approach 1: Breadth First Search**

```java
private int[] color;
private boolean[] marked;
private int V;

public int[] gardenNoAdj(int N, int[][] paths) {
    V = N;
    List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];
    
    for (int v = 0; v < V; v++) {
        adj[v] = new ArrayList<>();
    }
    
    for (int[] path : paths) {
        int u = path[0] - 1;
        int v = path[1] - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    
    color = new int[V];
    marked = new boolean[V];
    
    for (int v = 0; v < V; v++) {
        bfs(adj, v);
    }
    
    return color;
}
```

**private helper methods**

```java
private void bfs(List<Integer>[] adj, int s) {
    if (marked[s]) return;
    
    marked[s] = true;
    color[s] = 1;
    
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    
    while (!q.isEmpty()) {
        int u = q.remove();
        for (int v : adj[u]) {
            if (marked[v])  continue;
            for (int c = 1; c <= 4; c++) {
                boolean flag = true;
                for (int x : adj[v]) {
                    if (c == color[x]) flag = false;
                }
                if (flag) {
                    color[v] = c; break;
                }
            }
            marked[v] = true;
            q.add(v);
        }
    }
}
```

**Approach 2: Depth First Search**

```java
private int[] color;
private boolean[] marked;
private int V;

public int[] gardenNoAdj(int N, int[][] paths) {
    V = N;
    List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];
    
    for (int v = 0; v < V; v++) {
        adj[v] = new ArrayList<>();
    }
    
    for (int[] path : paths) {
        int u = path[0] - 1;
        int v = path[1] - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    
    color = new int[V];
    marked = new boolean[V];
    
    for (int v = 0; v < V; v++) {
        if (!marked[v]) {
            color[v] = 1;
            dfs(adj, v);
        }
    }
    
    return color;
}
```

**private helper methods**

```java
private void dfs(List<Integer>[] adj, int u) {
    if (marked[u]) return;
    
    marked[u] = true;
    for (int v : adj[u]) {
        for (int c = 1; c <= 4; c++) {
            boolean flag = true;
            for (int x : adj[v]) {
                if (c == color[x]) flag = false;
            }
            if (flag) {
                color[v] = c; break;
            }
        }
        dfs(adj, v);
    }
}    
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/flower-planting-with-no-adjacent