class Solution {
    private int[] color;
    private boolean[] marked;
    private int V;
    
    private void bfs(List<Integer>[] adj, int s) {
        if (marked[s]) return;
        
        marked[s] = true;
        color[s] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : adj[u]) {
                if (marked[v])  continue;
                for (int c = 1; c <= 4; c++) {
                    boolean flag = true;
                    for (int x : adj[v]) {
                        if (c == color[x]) flag = false;
                    }
                    if (flag) {
                        color[v] = c; break;
                    }
                }
                marked[v] = true;
                q.add(v);
            }
        }
    }
    
    public int[] gardenNoAdj(int N, int[][] paths) {
        V = N;
        List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];
        
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        color = new int[V];
        marked = new boolean[V];
        
        for (int v = 0; v < V; v++) {
            bfs(adj, v);
        }
        
        return color;
    }
}