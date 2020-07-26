# Heavy cycle edges

## Solution

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	    WeightedGraph G = new WeightedGraph(V);
	    for (int i = 0; i < E; i++) {
		int v = in.nextInt();
		int w = in.nextInt();
		int weight = in.nextInt();
		G.addEdge(new Edge(v, w, weight));
	    }
	    MST mst = new MST(G);
	    List<Integer> weights = mst.weights();
	    if (weights.size() > 0) {
		Collections.sort(weights);
		int count = 0;
		for (int w : weights) {
		    System.out.print(w);
		    if (++count < weights.size())
			System.out.print(" ");
		}
		System.out.println();
	    } else {
		System.out.println("forest");
	    }
	}
	in.close();
    }
}

class MST {
    private List<Edge> mst = new ArrayList<Edge>();
    private List<Integer> weights = new ArrayList<>();

    public MST(WeightedGraph G) {
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	for (Edge e : G.edges()) {
	    pq.add(e);
	}

	UnionFind uf = new UnionFind(G.V());
	while (!pq.isEmpty()) {
	    Edge e = pq.poll();
	    int v = e.either(), w = e.other(v);
	    if (!uf.connected(v, w)) {
		uf.union(v, w);
		mst.add(e);
	    } else {
		weights.add(e.weight());
	    }
	}
    }

    public List<Integer> weights() {
	return weights;
    }
}

class Edge implements Comparable<Edge> {
    private final int v, w;
    private final int weight;

    // create a weighted edge v-w
    public Edge(int v, int w, int weight) {
	this.v = v;
	this.w = w;
	this.weight = weight;
    }

    // either end point
    public int either() {
	return v;
    }

    // the end point that's not v
    public int other(int vertex) {
	if (v == vertex)
	    return w;
	else
	    return v;
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

    // the weight
    public int weight() {
	return weight;
    }
}

class WeightedGraph {
    private List<Edge> adj;
    private int V;

    public WeightedGraph(int V) {
	adj = new ArrayList<>();
	this.V = V;
    }

    public void addEdge(Edge e) {
	adj.add(e);
    }

    public Iterable<Edge> edges() {
	return adj;
    }

    public int V() {
	return V;
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