class Solution {
    public int[] sortArrayByParity(int[] A) {
	    int[] ans = new int[A.length];
	    int left = 0, right = A.length - 1;
	    for (int val : A) {
	        if (val % 2 == 0)
	            ans[left++] = val;
	        else
	            ans[right--] = val;
	    }
	    return ans;
	}
}