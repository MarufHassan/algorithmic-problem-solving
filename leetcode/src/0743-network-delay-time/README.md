# [743. Network Delay Time][title]

## Problem Description

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

## Solution

**Approach 1: Dijkstra Shortest Path basic algorithm**

```java
private static final int INFINITY = Integer.MAX_VALUE;

private List<Integer>[] adj, weight;
private int[] distTo;
private boolean[] marked;
private int V;

public int networkDelayTime(int[][] times, int N, int K) {        
    V = N;
    adj = (List<Integer>[]) new ArrayList[V];
    weight = (List<Integer>[]) new ArrayList[V];
    
    for (int v = 0; v < V; v++) {
        adj[v] = new ArrayList<>();
        weight[v] = new ArrayList<>();
    }
    
    for (int[] v : times) {
        adj[v[0] - 1].add(v[1] - 1);
        weight[v[0] - 1].add(v[2]);
    }
    
    distTo = new int[V];
    marked = new boolean[V];
    Arrays.fill(distTo, INFINITY);
    
    
    distTo[K - 1] = 0;
    
    for (int count = 0; count < V - 1; count++) {
        int v = minVertex();
        marked[v] = true;
        for (int i = 0; i < adj[v].size(); i++) {
            int w = adj[v].get(i);
            if (!marked[w])
                relax(v, w, weight[v].get(i));
        }
    }
    
    int delay = -1;
    for (int v = 0; v < V; v++) {
        if (distTo[v] == INFINITY) return -1;
        delay = Math.max(distTo[v], delay);
    }
    
    return delay;
}
```

**private helper methods**

```java
private void relax(int v, int w, int weight) {
    if (distTo[v] != INFINITY && distTo[v] + weight < distTo[w]) {
        distTo[w] = distTo[v] + weight;
    }
}

private int minVertex() {
    int minD = INFINITY;
    int minV = -1;
    for (int v = 0; v < V; v++) {
        if (!marked[v]) {
            if (distTo[v] < minD) {
                minD = distTo[v];
                minV = v;
            }
        }
    }
    return minV;
}
```

**Approach 2: Dijkstra Shortest Path Heap Implementation**

```java
public int networkDelayTime(int[][] times, int N, int K) {        
    V = N;
    adj = (List<Integer>[]) new ArrayList[V];
    weight = (List<Integer>[]) new ArrayList[V];
    
    for (int v = 0; v < V; v++) {
        adj[v] = new ArrayList<>();
        weight[v] = new ArrayList<>();
    }
    
    for (int[] v : times) {
        adj[v[0] - 1].add(v[1] - 1);
        weight[v[0] - 1].add(v[2]);
    }
    
    distTo = new int[V];
    Arrays.fill(distTo, INFINITY);
    
    IndexMinPQ pq = new IndexMinPQ(V);
    pq.insert(K - 1, 0);
    distTo[K - 1] = 0;
    
    while (!pq.isEmpty()) {
        int v = pq.delMin();
        for (int i = 0; i < adj[v].size(); i++) {
            int w = adj[v].get(i);
            relax(pq, v, w, weight[v].get(i));
        }
    }
    
    int delay = -1;
    for (int v = 0; v < V; v++) {
        if (distTo[v] == INFINITY) return -1;
        delay = Math.max(distTo[v], delay);
    }
    
    return delay;
}
```

**private helper methods**

```java
private void relax(IndexMinPQ pq, int v, int w, int weight) {
    if (distTo[v] != INFINITY && distTo[v] + weight < distTo[w]) {
        distTo[w] = distTo[v] + weight;
        
        if (pq.contains(w))
            pq.decreaseKey(w, distTo[w]);
        else
            pq.insert (w, distTo[w]);
    }
}
```

**Indexed Minimum Priority Queue Class**

```java
class IndexMinPQ {
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private int[] keys;      // keys[i] = priority of i

    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        keys = new int[maxN + 1];
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];
        Arrays.fill(keys, -1);
        Arrays.fill(qp, -1);
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int i, int key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1; // delete
        keys[min] = -1;
        pq[n + 1] = -1; // not needed
        return min;
    }

    public void decreaseKey(int i, int key) {
        keys[i] = key;
        swim(qp[i]);
    }

   /***************************************************************************
    * Heap helper functions.
    ***************************************************************************/

   private boolean greater(int i, int j) {
        return Integer.compare(keys[pq[i]], keys[pq[j]]) > 0;
    }

   private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/network-delay-time/