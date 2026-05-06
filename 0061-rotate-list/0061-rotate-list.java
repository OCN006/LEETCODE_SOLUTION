class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode temp = head;
        int length = 1;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        int pos = k%length;
        if(pos==0) return head;

        ListNode curr = head;
        for(int i=0;i<length-pos-1;i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next=null;
        temp.next=head;
        return newHead;
    }
}