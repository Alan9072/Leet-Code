class Solution {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode nxtPointer = head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = dummy;
        int sum = 0;
        while(nxtPointer!=null){
            if(nxtPointer.val == 0){
                ListNode node = new ListNode();
                node.val = sum;
                pointer.next = node;
                pointer = pointer.next;
                sum = 0;
                nxtPointer = nxtPointer.next;
            }
            else{
                sum = sum + nxtPointer.val;
                nxtPointer = nxtPointer.next;
            }
        }
        pointer.next = null;
        return dummy.next;
    }
}
