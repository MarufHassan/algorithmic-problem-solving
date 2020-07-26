# Claw decomposition

## Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int V = in.nextInt();
			if (V == 0) break;
			
			Graph G = new Graph(V);
			while (true) {
				int v = in.nextInt();
				int w = in.nextInt();
				if (v == 0 && w == 0)	break;
				G.addEdge(v - 1, w - 1);
			}
			Bipartite b = new Bipartite(G);
			if (b.isBipartite())	System.out.println("YES"); 	
			else					System.out.println("NO");
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
	
	public Bipartite(Graph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		isTwoColorable = true;
		
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s] && isTwoColorable)		dfs(G, s);
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, w);
			} else if (color[v] == color[w])	isTwoColorable = false;
		}
	}
	
	public boolean isBipartite() {
		return isTwoColorable;
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**