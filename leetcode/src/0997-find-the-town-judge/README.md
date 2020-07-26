# [997. Find the Town Judge][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: N = 2, trust = [[1,2]]
Output: 2
```

**Example 2:**

```
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
```

**Example 3:**

```
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
```

## Solution

```java
public int findJudge(int N, int[][] trust) {
    Digraph G = new Digraph(N);
    
    for (int i = 0; i < trust.length; i++) {
        G.addEdge(trust[i][0] - 1, trust[i][1] - 1);
    }
    
    int townjudge = -1;
    for (int v = 0; v < N; v++) {
        if (G.indegree(v) == N - 1 && G.outdegree(v) == 0) {
            townjudge = v + 1;
            break;
        }
    }
    return townjudge;
}
```

**Digraph API**

```java
class Digraph {
    
    private List<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    public Digraph(int V) {
        indegree = new int[V];
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
    }
    
    public int outdegree(int v) {
        return adj[v].size();
    }

    public int indegree(int v) {
        return indegree[v];
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-the-town-judge/