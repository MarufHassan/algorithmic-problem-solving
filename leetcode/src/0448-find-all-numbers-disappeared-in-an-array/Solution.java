class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int elements = Math.abs(nums[i]);
            if (nums[elements - 1] > 0)
                nums[elements - 1] = -nums[elements - 1];
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0)
                res.add(i);
        }
        return res;
    }
}