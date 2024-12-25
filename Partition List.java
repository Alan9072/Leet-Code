/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode sptr = small;
        ListNode lptr = large;

        ListNode ptr = head;
        while(ptr!=null){
            if(ptr.val >= x){
                lptr.next = ptr;
                lptr = lptr.next;
                ptr = ptr.next;
                lptr.next = null;

            }else{
                sptr.next = ptr;
                sptr = sptr.next;
                ptr = ptr.next;
                sptr.next = null;
            }
            
        }
        ptr = small;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = large.next;
        return small.next;
    }
}
