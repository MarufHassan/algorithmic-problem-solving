class Solution {
    private List<List<Integer>> collections = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length - 1);
        return collections;
    }
    
    private void permute(int[] nums, int left, int right) {
        if (left == right) {
            collections.add(asList(nums)); return;
        }
        for (int i = left; i <= right; i++) {
            swap(nums, i, left);
            permute(nums, left + 1, right);
            swap(nums, i, left);
        }
    }
    
    private List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int v : nums) {
            list.add(v);
        }
        return list;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}