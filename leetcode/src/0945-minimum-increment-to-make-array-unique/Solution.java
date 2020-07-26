import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] A) {
    	if (A.length <= 0)	return 0;

		Arrays.sort(A);
		int sum = 0, distinctSum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int prev = A[0];
		distinctSum = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= prev) {
				prev += 1;
				distinctSum += prev;
			} else {
				distinctSum += A[i];
				prev = A[i];
			}
		}
		return distinctSum - sum;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();

    	int[] A = new int[] {1, 2, 2};
    	assert s.minIncrementForUnique(A) == 1;

    	A = new int[] {3, 2, 1, 2, 1, 7};
    	assert s.minIncrementForUnique(A) == 6;

    	A = new int[] {};
    	assert s.minIncrementForUnique(A) == 0;
    }
}