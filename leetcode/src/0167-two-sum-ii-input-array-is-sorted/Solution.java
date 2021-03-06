class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--; 
            else
                return new int[] {lo + 1, hi + 1};
        }
        return null;
    }
}