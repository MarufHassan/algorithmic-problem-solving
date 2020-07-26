class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer v1, Integer v2) {
                int f1 = freq.get(v1);
                int f2 = freq.get(v2);
                return Integer.compare(f1, f2);
            }
        });
        for (int key : freq.keySet()) {
            pq.offer(key);
            if (pq.size() > k)
                pq.poll();
        }
        List<Integer> candidates = new ArrayList<>();
        while (pq.size() > 0) {
            candidates.add(pq.poll());
        }
        Collections.reverse(candidates);
        return candidates;
    }
}