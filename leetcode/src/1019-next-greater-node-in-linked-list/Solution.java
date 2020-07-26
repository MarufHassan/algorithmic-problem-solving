class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> A = new ArrayList<>();
        while (head != null) {
            A.add(head.val);
            head = head.next;
        }
        int[] ans = new int[A.size()];
        for (int i = 0; i < ans.length; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
                ans[stack.pop()] = A.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}