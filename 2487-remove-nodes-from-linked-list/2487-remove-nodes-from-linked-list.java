class Solution {
    public ListNode removeNodes(ListNode head) {
        
        ListNode rev = reverse(head);

        ListNode temp = rev;
        int max = temp.val;

        while (temp != null && temp.next != null) {
            if (temp.next.val < max) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
                max = temp.val;
            }
        }

        return reverse(rev);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
