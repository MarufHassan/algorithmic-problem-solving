class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return (p2[0] + p2[1]) - (p1[0] + p1[1]);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new int[] {nums1[i], nums2[j]});
                if (pq.size() > k)
                    pq.poll();
            }
        }
        List<int[]> candidates = new ArrayList<>();
        while (pq.size() > 0) {
            candidates.add(pq.poll());
        }
        return candidates;
    }
}