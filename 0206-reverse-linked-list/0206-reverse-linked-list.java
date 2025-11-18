
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode node = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=node;
            node=head;
            head=temp;
        }
        return node;
    }
}