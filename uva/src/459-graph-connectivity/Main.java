import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		in.nextLine();
		
		for (int t = 0; t < n; t++) {
			int V = in.nextLine().charAt(0) - 'A' + 1;
			Graph G = new Graph(V);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.length() == 0)	break;
				
				int v = line.charAt(0) - 'A';
				int w = line.charAt(1) - 'A';
				G.addEdge(v, w);
			}
			DFS dfs = new DFS(G);
			System.out.println(dfs.count());
			if (t != n - 1)	System.out.println();
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

class DFS {
	private boolean[] marked;
	private int count;
	
	public DFS(Graph G) {
		marked = new boolean[G.V()];
		count = 0;
		
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}
	
	public int count() {
		return count;
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) dfs(G, w);
		}
	}
}