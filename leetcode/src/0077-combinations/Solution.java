class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> powerset = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
        find(nums, k, 0, new ArrayList<>(), powerset);
        return powerset;
    }
    
    private void find(int[] nums, int k, int start, List<Integer> chosen, List<List<Integer>> powerset) {
        if (chosen.size() == k)
            powerset.add(new ArrayList<>(chosen));
        
        for (int i = start; i != nums.length; i++) {
            chosen.add(nums[i]);
            find(nums, k, i + 1, chosen, powerset);
            chosen.remove(chosen.size() - 1);
        }
    }
}