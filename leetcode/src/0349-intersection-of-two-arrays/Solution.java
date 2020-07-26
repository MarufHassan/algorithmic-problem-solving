class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] ans = new int[nums1.length];
        int i = 0, idx = 0;
        while (i < nums1.length) {
            // skip duplicates
            while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                i++;
            }
            if (contains(nums2, nums1[i]))
                ans[idx++] = nums1[i];
            i += 1;
        }
        return Arrays.copyOf(ans, idx);
    }
    
    private boolean contains(int[] num, int key) {
        int lo = 0, hi = num.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > num[mid])
                lo = mid + 1;
            else if (key < num[mid])
                hi = mid - 1;
            else
                return true;
        }
        return false;
    }
}