class Solution {
    private static final int INF = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n], curr = null;
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        
        for (int i = K; i >= 0; i--) {
            curr = Arrays.copyOf(cost, cost.length);
            
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], weight = flight[2];
                // edge relaxation
                if (cost[u] != INF && cost[u] + weight < curr[v]) {
                    curr[v] = cost[u] + weight;
                }
            }
            cost = curr;
        }
        
        return (cost[dst] == INF) ? -1 : cost[dst];
    }
}