class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        dummy.next=head;
        ListNode curr = head;
        while(curr!=null&&curr.next!=null)
        {
            if(curr.val==curr.next.val)
            {
                while(curr.next!=null&&curr.val==curr.next.val)
                {
                    curr=curr.next;
                }
                dummy.next=curr.next;
            }
            else
            {
                dummy=dummy.next;
            }
            curr=curr.next;
        }
        return prev.next;
    }
}