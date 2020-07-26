class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int island = 0;
        
        for (int[] v : stones) {
            if (!visited.contains(v)) {
                explore(stones, v, visited);
                island++;
            }
        }
        
        return stones.length - island;
    }
    
    private void explore(int[][] stones, int[] v, Set<int[]> visited) {
        if (visited.contains(v)) return;
        
        visited.add(v);
        for (int[] w : stones) {
            if (v[0] == w[0] && v[1] == w[1])   continue;
            if (v[0] == w[0] || v[1] == w[1]) {
                if (!visited.contains(w)) {
                    explore(stones, w, visited);
                }
            }
        }
    }
}