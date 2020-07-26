class Solution {
    private final static int WHITE = 0;
    private final static int GRAY = 1;
    private final static int BLACK = 2;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        
        List<Integer> res = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            if (dfs(graph, v, color))
                res.add(v);
        }
        
        return res;
    }
    
    private boolean dfs(int[][] graph, int node, int[] color) {
        if (color[node] != WHITE)
            return color[node] == BLACK;
        color[node] = GRAY;
        for (int adj : graph[node]) {
            if (!dfs(graph, adj, color))
                return false;
        }
        color[node] = BLACK;
        return true;
    }
}