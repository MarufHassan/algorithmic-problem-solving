class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int b : barcodes) {
            freq.put(b, freq.getOrDefault(b, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return freq.get(i2) - freq.get(i1);
            }
        });
        
        for (int b : freq.keySet()) {
            pq.offer(b);
        }
        
        int[] ans = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int element = pq.poll();
            for (int j = 1; j <= freq.get(element); j++) {
                ans[i] = element;
                i += 2;
                if (i >= barcodes.length) {
                    i = 1;
                }
            }
        }
        
        return ans;
    }
}