class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs.length <= 0) 	return "";
    	return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int low, int high) {
    	if (low >= high)		return strs[low];

    	int mid = low + (high - low) / 2;

    	String leftLcp	= 	longestCommonPrefix(strs, low, mid);
    	String rightLcp	= 	longestCommonPrefix(strs, mid + 1, high);

    	return commonPrefix(leftLcp, rightLcp);
    }

    // common prefix between two string
    private String commonPrefix(String left, String right) {
    	int len = Math.min(left.length(), right.length());
    	for (int i = 0; i < len; i++) {
    		if (left.charAt(i) != right.charAt(i))
    			return left.substring(0, i);
    	}
    	return left.substring(0, len);
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
        
        String[] strs = new String[] {"flower", "flow", "flight"};
        assert s.longestCommonPrefix(strs).equals("fl");

        strs = new String[] {"dog", "racecar","car"};
        assert s.longestCommonPrefix(strs).equals("");

        strs = new String[] {"leetcode", "leets", ""};
        assert s.longestCommonPrefix(strs).equals("");

        strs = new String[] {"", "", ""};
        assert s.longestCommonPrefix(strs).equals("");
    }
}