class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)return head;
        ListNode pointer = head;
        ListNode head2 = head.next;
        ListNode pointer2 = head2;

        while(pointer!=null && pointer.next!=null){
            if(pointer.next.next == null){
                pointer.next = null;
            }
            else{
                pointer.next = pointer.next.next;
                pointer = pointer.next;
            }
           
            if(pointer2.next == null){
                pointer2.next = null;
            }
            else{
                 pointer2.next = pointer2.next.next;
                 pointer2 = pointer2.next;
            }
           
        }
        pointer.next = head2;
        return head;
    }
}
