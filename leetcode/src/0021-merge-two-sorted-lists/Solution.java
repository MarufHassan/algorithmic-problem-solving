class Solution {
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val <= right.val) {
            left.next = mergeTwoLists(left.next, right);
            return left;
        } else {
            right.next = mergeTwoLists(left, right.next);
            return right;
        }
    }
}