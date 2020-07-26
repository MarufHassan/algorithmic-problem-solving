class Solution {
    public List<Integer> pancakeSort(int[] A) {
	    List<Integer> flips = new ArrayList<>();
	    
	    for (int i = A.length; i >= 1; i--) {
	        if (A[i - 1] == i)  continue;
	        int index = indexOf(A, i);
	        reverse(A, 0, index);
	        reverse(A, 0, i - 1);
	        flips.add(index + 1);
	        flips.add(i);
	    }
	    return flips;
	}

	private int indexOf(int[] nums, int key) {
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == key)
	            return i;
	    }
	    return -1;
	}

	private void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start++] = nums[end];
	        nums[end--] = temp;
	    }
	}
}