class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int v : nums2) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        int[] ans = new int[nums1.length];
        int idx = 0;
        for (int v : nums1) {
            int val = map.getOrDefault(v, -1);
            if (val > 0) {
                ans[idx++] = v;
                map.put(v, val - 1);
            }
        }
        return Arrays.copyOf(ans, idx);
    }
}