class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        return freq.getOrDefault(target, 0) > nums.length / 2;
    }
}