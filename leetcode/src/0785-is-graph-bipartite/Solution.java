class Solution {
    private static final int RED = 1;
    private static final int BLUE = 2;
    
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (graph[i].length == 0 || color[i] != -1)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = RED;

            while (!q.isEmpty()) {
                int v = q.remove();
                for (int w : graph[v]) {
                    if (color[w] == -1) {
                        q.add(w);
                        color[w] = (color[v] == RED) ? BLUE : RED;
                    } else if (color[v] == color[w])
                        return false;
                }
            }
        }
        
        return true;
    }
}