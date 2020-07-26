import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = 0;
		while (true) {
			int E = in.nextInt();
			if (E == 0)
				break;

			Graph G = new Graph();
			for (int i = 0; i < E; i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				G.addEdge(v, w);
			}
			while (true) {
				int source = in.nextInt();
				int ttl = in.nextInt();
				if (source == 0 && ttl == 0)
					break;

				BFS bfs = new BFS(G, source);
				int notReachable = 0;
				for (int v : G.vertices()) {
					if (!bfs.hasPathTo(v) || bfs.distTo(v) > ttl)
						notReachable++;
				}
				System.out
						.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.\n",
								++cases, notReachable, source, ttl);
			}
		}
		in.close();
	}
}

class Graph {

	private Set<Integer> vertices;
	private Map<Integer, List<Integer>> adj;

	public Graph() {
		vertices = new HashSet<>();
		adj = new HashMap<Integer, List<Integer>>();
	}

	public void addEdge(int v, int w) {
		if (!adj.containsKey(v)) {
			adj.put(v, new ArrayList<Integer>());
		}
		if (!adj.containsKey(w)) {
			adj.put(w, new ArrayList<Integer>());
		}
		vertices.add(v);
		vertices.add(w);
		List<Integer> t = adj.get(v);
		t.add(w);
		adj.put(v, t);
		t = adj.get(w);
		t.add(v);
		adj.put(w, t);
	}

	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}

	public int V() {
		return vertices.size();
	}

	public Iterable<Integer> vertices() {
		return vertices;
	}
}

class BFS {
	private static final int INFINITY = Integer.MAX_VALUE;

	private Map<Integer, Boolean> marked;
	private Map<Integer, Integer> distTo;
	private int s;

	public BFS(Graph G, int s) {
		this.s = s;
		marked = new HashMap<>();
		distTo = new HashMap<>();
		for (int v : G.vertices()) {
			marked.put(v, false);
			distTo.put(v, INFINITY);
		}
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		distTo.put(s, 0);
		marked.put(s, true);
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked.get(w)) {
					distTo.put(w, distTo.get(v) + 1);
					marked.put(w, true);
					q.add(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked.get(v);
	}

	public int source() {
		return s;
	}

	public int distTo(int v) {
		return distTo.get(v);
	}
}
