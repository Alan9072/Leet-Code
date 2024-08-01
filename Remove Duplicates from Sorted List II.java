class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        ListNode prev = dummy;
        if(head == null)return null;
        dummy.next = head;

        while(curr!=null && curr.next!=null){
                if(curr.val == curr.next.val){
                    while( curr.next!=null && curr.val == curr.next.val ){
                        curr = curr.next;
                    }
                    curr = curr.next;
                    prev.next = curr;
                }
                else{
                    curr = curr.next;
                    prev = prev.next;
                    
                }
        }
    return dummy.next;
    }
}
