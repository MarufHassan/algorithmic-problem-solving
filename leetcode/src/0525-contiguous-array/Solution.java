class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0 ? -1 : 1);
            map.putIfAbsent(count, i);
            ans = Math.max(ans, i - map.get(count));
        }
        
        return ans;
    }
}