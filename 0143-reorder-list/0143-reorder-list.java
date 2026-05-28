class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null;
        ListNode node = null;

        while (second != null) {
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = node;

        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }        
    }
}