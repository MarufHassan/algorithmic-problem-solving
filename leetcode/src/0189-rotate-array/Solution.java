class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int sets = gcd(nums.length, k);
        
        for (int i = sets - 1; i >= 0; i--) {
            int j = i;
            int temp = nums[i];
            int step = (j - k) % nums.length;
            if (step < 0)   step += nums.length;
            while (step != i) {
                nums[j] = nums[step];
                j = step;
                step = (j - k) % nums.length;
                if (step < 0)   step += nums.length;
            }
            nums[j] = temp;
        }
    }
    
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}