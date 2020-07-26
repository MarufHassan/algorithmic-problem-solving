class Solution {
    private List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        
        combinationSum2(candidates, target, 0, new ArrayList<>());
        
        return ans;
    }
    
    private void combinationSum2(int[] candidates, int target, int index, List<Integer> chosen) {
        if (target <= 0) {
            if (target == 0)
                ans.add(new ArrayList<>(chosen));
            return;
        }
        
        for (int i = index; i != candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                chosen.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, chosen);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}