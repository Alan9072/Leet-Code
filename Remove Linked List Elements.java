class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = head;
        ListNode curr = dummy;
        while(pointer!=null){
           
            if(pointer.val!=val){
                curr.next = pointer;
                curr = curr.next;
                pointer = pointer.next;
            }
            else{
                    pointer = pointer.next;
                }
            }
        curr.next = null;
        return dummy.next;
    }
}
