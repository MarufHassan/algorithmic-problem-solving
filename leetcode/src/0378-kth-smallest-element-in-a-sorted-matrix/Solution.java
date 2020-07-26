class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        build(nums, N);
        for (int i = 0; i < k - 1; i++) {
            extract(nums, N--);
        }
        return extract(nums, N);
    }
    
    private int extract(int[] nums, int N) {
        int max = nums[0];
        exch(nums, 0, N - 1);
        sink(nums, 0, N - 1);
        return max;
    }
    
    private void build(int[] nums, int N) {
        for (int k = nums.length / 2; k >= 0; k--) {
            sink(nums, k, N);
        }
    }
    
    private void sink(int[] nums, int k, int N) {
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j < N - 1 && nums[j + 1] > nums[j])
                j++;
            if (nums[k] >= nums[j])
                break;
            exch(nums, k, j);
            k = j;
        }
    }
    
    private void exch(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}