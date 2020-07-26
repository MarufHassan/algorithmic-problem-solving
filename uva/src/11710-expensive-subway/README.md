# Expensive subway

## Solution

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (true) {
	    int V = in.nextInt();
	    int E = in.nextInt();
	    if (V == 0 && E == 0)
		break;
	    Map<String, Integer> maps = new HashMap<>();
	    for (int i = 0; i < V; i++) {
		maps.put(in.next(), i);
	    }
	    List<Edge> edges = new ArrayList<>();
	    for (int i = 0; i < E; i++) {
		int v = maps.get(in.next());
		int w = maps.get(in.next());
		int weight = in.nextInt();
		edges.add(new Edge(v, w, weight));
	    }
	    in.next();
	    MST m = new MST(edges, V);
	    if (m.mstSize() < V - 1) {
		System.out.println("Impossible");
	    } else {
		System.out.println(m.weight);
	    }
	}
	in.close();
    }
}

class MST {
    private List<Edge> mst = new ArrayList<Edge>();
    public int weight;

    public MST(List<Edge> edges, int V) {
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	weight = 0;

	for (Edge e : edges) {
	    pq.add(e);
	}

	UnionFind uf = new UnionFind(V);
	while (!pq.isEmpty()) {
	    Edge e = pq.poll();
	    int v = e.v, w = e.w;
	    if (!uf.connected(v, w)) {
		uf.union(v, w);
		mst.add(e);
		weight += e.weight;
	    }
	}
    }

    public int mstSize() {
	return mst.size();
    }
}

class Edge implements Comparable<Edge> {
    public final int v, w;
    public final int weight;

    // create a weighted edge v-w
    public Edge(int v, int w, int weight) {
	this.v = v;
	this.w = w;
	this.weight = weight;
    }

    // compare this edge to that edge
    public int compareTo(Edge that) {
	if (this.weight < that.weight)
	    return -1;
	else if (this.weight > that.weight)
	    return +1;
	else
	    return 0;
    }
}

class UnionFind {
    private int[] parent; // parent[i] = parent of i
    private byte[] rank; // rank[i] = rank of subtree rooted at i (never more
			 // than 31)

    public UnionFind(int N) {
	parent = new int[N];
	rank = new byte[N];
	for (int i = 0; i < N; i++) {
	    parent[i] = i;
	    rank[i] = 0;
	}
    }

    public int find(int p) {
	while (p != parent[p]) {
	    parent[p] = parent[parent[p]]; // path compression by halving
	    p = parent[p];
	}
	return p;
    }

    public boolean connected(int p, int q) {
	return find(p) == find(q);
    }

    public void union(int p, int q) {
	int rootP = find(p);
	int rootQ = find(q);
	if (rootP == rootQ)
	    return;

	// make root of smaller rank point to root of larger rank
	if (rank[rootP] < rank[rootQ])
	    parent[rootP] = rootQ;
	else if (rank[rootP] > rank[rootQ])
	    parent[rootQ] = rootP;
	else {
	    parent[rootQ] = rootP;
	    rank[rootP]++;
	}
    }
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**