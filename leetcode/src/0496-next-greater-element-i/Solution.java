class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums2) {
            while (!stack.empty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int i = 0;
        for (int n : nums1)
            result[i++] = map.getOrDefault(n, -1);
        return result;
    }
}