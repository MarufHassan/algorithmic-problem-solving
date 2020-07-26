class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        
        for (int i = 0; i < values.length; i++) {
            freq.putIfAbsent(labels[i], 0);
            pq.offer(new int[] {values[i], labels[i]});
        }
        
        int sum = 0, i = 0;
        while (i < num_wanted && !pq.isEmpty()) {
            int[] pair = pq.remove();
            if (freq.get(pair[1]) < use_limit) {
                sum += pair[0];
                freq.put(pair[1], freq.get(pair[1]) + 1);
                i++;
            }
        }
        return sum;
    }
}