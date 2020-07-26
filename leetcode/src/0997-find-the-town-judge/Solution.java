class Solution {
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
}
class Digraph {
	
	private List<Integer>[] adj;	// adj[v] = adjacency list for vertex v
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