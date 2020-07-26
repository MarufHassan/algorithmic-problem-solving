class Solution {
    private boolean hasCycle = false;
    private boolean[] marked, onStack;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
        }
        
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v] && !hasCycle)
                dfs(adj, v);
        }
        
        return !hasCycle;
    }
    
    private void dfs(List<Integer>[] adj, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : adj[v]) {
            if (!marked[w])
                dfs(adj, w);
            else if (onStack[w])
                hasCycle = true;
        }
        onStack[v] = false;
    }
}