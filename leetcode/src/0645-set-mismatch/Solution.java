class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0, n = nums.length, dup = -1;
        
        for (int v : nums) {
            if (seen.contains(v))
                dup = v;
            else
                seen.add(v);
            sum += v;
        }
        int missing = (n * (n + 1) / 2) - (sum - dup);
        return new int[] {dup, missing};
    }
}