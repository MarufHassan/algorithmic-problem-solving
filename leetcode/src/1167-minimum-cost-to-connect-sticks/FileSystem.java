class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int stick : sticks) {
            pq.offer(stick);
        }
        
        int cost=  0;
        while (pq.size() > 1) {
            int pop = pq.remove() + pq.remove();
            cost += pop;
            pq.offer(pop);
        }
        return cost;
    }
}