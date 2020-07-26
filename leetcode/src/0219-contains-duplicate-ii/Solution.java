class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> index = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(nums[i])) {
                int idx = index.get(nums[i]);
                if (i - idx <= k)
                    return true;
                
            }
            index.put(nums[i], i);
        }
        return false;
    }
}