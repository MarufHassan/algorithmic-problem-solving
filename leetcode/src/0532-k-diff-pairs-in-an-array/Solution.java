class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1)
                    count++;
            } else {
                if (map.containsKey(key + k))
                    count++;
            }
        }
        
        return count;
    }
}