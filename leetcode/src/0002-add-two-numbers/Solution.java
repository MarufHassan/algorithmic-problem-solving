class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0, sum = 0, carry = 0;
        ListNode head = new ListNode(0), result = head;
        while (l1 != null ||  l2 != null) {
            n1 = (l1 == null) ? 0 : l1.val;
            n2 = (l2 == null) ? 0 : l2.val;
            
            sum = n1 + n2 + carry;
            carry = sum / 10;
            
            result.next = new ListNode(sum % 10);
            result = result.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0)
            result.next = new ListNode(carry);
        return head.next;
    }
}