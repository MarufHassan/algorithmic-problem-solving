class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), powerset);
        return powerset;
    }
    
    private void find(int[] nums, int start, List<Integer> chosen, List<List<Integer>> powerset) {
        powerset.add(new ArrayList<>(chosen));
        for (int i = start; i != nums.length; i++) {
            chosen.add(nums[i]);
            find(nums, i + 1, chosen, powerset);
            chosen.remove(chosen.size() - 1);
        }
    }
}