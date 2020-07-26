class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head, next;
        
        while (curr != null) {
            next = curr.next;
            while (next != null && curr.val == next.val)
                next = next.next;
            curr.next = next;
            curr = curr.next;
        }
        return head;
    }
}