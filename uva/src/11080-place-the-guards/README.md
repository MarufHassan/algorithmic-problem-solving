# Place the guards

## Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int t = 0; t < cases; t++) {
			int V = in.nextInt();
			int E = in.nextInt();

			Graph G = new Graph(V);
			for (int i = 0; i < E; i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				G.addEdge(v, w);
			}
			Bipartite b = new Bipartite(G);
			if (b.isBipartite())
				System.out.println(b.count());
			else
				System.out.println("-1");
		}
		in.close();
	}
}

class Graph {

	private final int V;
	private List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;

		adj = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int V() {
		return V;
	}
}

class Bipartite {
	private boolean marked[];
	private boolean color[];
	private boolean isTwoColorable;
	private int count;
	private int[] colorCount;

	public Bipartite(Graph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		isTwoColorable = true;
		count = 0;

		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				colorCount = new int[2];
				dfs(G, s);
				count += Math.max(1, Math.min(colorCount[0], colorCount[1]));
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		if (color[v]) {colorCount[1]++;} else {colorCount[0]++;}
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, w);
			} else if (color[v] == color[w])
				isTwoColorable = false;
		}
	}

	public boolean isBipartite() {
		return isTwoColorable;
	}

	public int count() {
		return count;
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**