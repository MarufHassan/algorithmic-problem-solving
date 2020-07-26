import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static double distance(double x1, double y1, double x2, double y2) {
	double x = Math.abs(x2 - x1);
	double y = Math.abs(y2 - y1);
	return Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tests = in.nextInt();
	for (int t = 1; t <= tests; t++) {
	    int V = in.nextInt();
	    double coord[][] = new double[V][2];
	    for (int i = 0; i < V; i++) {
		coord[i][0] = in.nextDouble();
		coord[i][1] = in.nextDouble();
	    }
	    List<Edge> edges = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
		for (int j = i + 1; j < V; j++) {
		    edges.add(new Edge(i, j, distance(coord[i][0], coord[i][1],
			    coord[j][0], coord[j][1])));
		}
	    }
	    KruskalMST mst = new KruskalMST(edges, V);
	    System.out.printf("%.2f\n", mst.weight());
	    if (t < tests)
		System.out.println();
	}
	in.close();
    }
}

class KruskalMST {
    private List<Edge> mst = new ArrayList<Edge>();
    private double weight;

    public KruskalMST(List<Edge> edges, int V) {
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	weight = 0.0;

	for (Edge e : edges) {
	    pq.add(e);
	}

	UnionFind uf = new UnionFind(V);
	while (!pq.isEmpty() && mst.size() < V - 1) {
	    Edge e = pq.poll();
	    int v = e.v, w = e.w;
	    if (!uf.connected(v, w)) {
		uf.union(v, w);
		mst.add(e);
		weight += e.weight;
	    }
	}
    }

    public double weight() {
	return weight;
    }
}

class Edge implements Comparable<Edge> {
    public final int v, w;
    public final double weight;

    // create a weighted edge v-w
    public Edge(int v, int w, double weight) {
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
