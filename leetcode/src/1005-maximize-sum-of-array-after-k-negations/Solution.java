class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int v : A)
            pq.offer(v);
        
        for (int k = 0; k < K; k++) {
            int min = pq.remove();
            pq.offer(-min);
        }
        int sum = 0;
        while (!pq.isEmpty())
            sum += pq.remove();
        return sum;
    }
}