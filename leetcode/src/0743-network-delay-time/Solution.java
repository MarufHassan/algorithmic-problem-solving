class Solution {
    private static final int INFINITY = Integer.MAX_VALUE;
    
    private List<Integer>[] adj, weight;
    private int[] distTo;
    private boolean[] marked;
    private int V;
    
    public int networkDelayTime(int[][] times, int N, int K) {        
        V = N;
        adj = (List<Integer>[]) new ArrayList[V];
        weight = (List<Integer>[]) new ArrayList[V];
        
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
            weight[v] = new ArrayList<>();
        }
        
        for (int[] v : times) {
            adj[v[0] - 1].add(v[1] - 1);
            weight[v[0] - 1].add(v[2]);
        }
        
        distTo = new int[V];
        Arrays.fill(distTo, INFINITY);
        
        IndexMinPQ pq = new IndexMinPQ(V);
        pq.insert(K - 1, 0);
        distTo[K - 1] = 0;
        
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (int i = 0; i < adj[v].size(); i++) {
                int w = adj[v].get(i);
                relax(pq, v, w, weight[v].get(i));
            }
        }
        
        int delay = -1;
        for (int v = 0; v < V; v++) {
            if (distTo[v] == INFINITY) return -1;
            delay = Math.max(distTo[v], delay);
        }
        
        return delay;
    }
    
    private void relax(IndexMinPQ pq, int v, int w, int weight) {
        if (distTo[v] != INFINITY && distTo[v] + weight < distTo[w]) {
            distTo[w] = distTo[v] + weight;
            
            if (pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert (w, distTo[w]);
        }
    }
}

class IndexMinPQ {
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private int[] keys;      // keys[i] = priority of i

    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        keys = new int[maxN + 1];
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];
        Arrays.fill(keys, -1);
        Arrays.fill(qp, -1);
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int i, int key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1; // delete
        keys[min] = -1;
        pq[n + 1] = -1; // not needed
        return min;
    }

    public void decreaseKey(int i, int key) {
        keys[i] = key;
        swim(qp[i]);
    }

   /***************************************************************************
    * Heap helper functions.
    ***************************************************************************/

   private boolean greater(int i, int j) {
        return Integer.compare(keys[pq[i]], keys[pq[j]]) > 0;
    }

   private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}