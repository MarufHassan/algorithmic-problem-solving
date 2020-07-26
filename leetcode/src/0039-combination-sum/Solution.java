class Solution {
    private List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        
        combinationSum(candidates, target, 0, new ArrayList<>());
        
        return ans;
    }
    
    private void combinationSum(int[] candidates, int target, int index, List<Integer> chosen) {
        if (target <= 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(chosen));
            }
            return;
        }
        if (index >= candidates.length) return;
        
        int value = candidates[index];
        chosen.add(value);        
        combinationSum(candidates, target - value, index, chosen);
        
        chosen.remove(chosen.size() - 1);
        combinationSum(candidates, target, index + 1, chosen);
    }
}