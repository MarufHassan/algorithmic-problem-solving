class Solution {
    private boolean hasCycle = false;
    private boolean[] marked, onStack;
    private int[] order;
    private int idx = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
        }
        
        order = new int[numCourses];
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v] && !hasCycle)
                dfs(adj, v);
        }
        
        return hasCycle ? new int[0] : reverse(order);
    }
    
    private int[] reverse(int[] order) {
        int i = 0, j = order.length - 1;
        while (i < j) {
            int t = order[i];
            order[i++] = order[j];
            order[j--] = t;
        }
        return order;
    }
    
    private void dfs(List<Integer>[] adj, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : adj[v]) {
            if (!marked[w] && !hasCycle)
                dfs(adj, w);
            else if (onStack[w])
                hasCycle = true;
        }
        order[idx++] = v;
        onStack[v] = false;
    }
}