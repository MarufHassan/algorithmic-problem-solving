class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] != 0) {
                    uf.union(i, j);
                }
            }
        }
        return uf.components();
    }
}
class UF {
    int[] id, rank;
    int components;
    
    public UF(int n) {
        id = new int[n];
        rank = new int[n];
        components = n;
        
        for (int i = 0; i < n; i++) 
            id[i] = i;
    }
    
    private int root(int i) {
        while (i != id[i]) {
            // path compression heuristics
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        // rank heuristics
        if (rank[i] < rank[j])
            id[i] = j;
        else {
            id[j] = i;
            if (rank[i] == rank[j])
                rank[j] += 1;
        }
        components--;
    }
    
    public int components() {
        return components;
    }
}