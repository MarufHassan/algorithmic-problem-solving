public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> augend = new Stack<>();
        Stack<Integer> addened = new Stack<>();
        ListNode x = l1, head;
        while (x != null) {
            augend.push(x.val);
            x = x.next;
        }
        
        x = l2;
        while (x != null) {
            addened.push(x.val);
            x = x.next;
        }
        
        head = new ListNode(0);
        int sum = 0;
        while (!augend.empty() || !addened.empty()) {
            if (!augend.empty())
                sum += augend.pop();
            if (!addened.empty())
                sum += addened.pop();
            head.val = sum % 10;
            x = new ListNode(sum / 10);
            x.next = head;
            head = x;
            sum /= 10;
        }
        
        return head.val == 0 ? head.next : head;
    }
}