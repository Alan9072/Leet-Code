/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode entry = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast!= null){
            slow = slow.next;
            if(fast.next == null){
                fast = null;
            }
            else{
                fast = fast.next.next;
            }
            ///////////////////////////////
            if(slow == fast){
                break;
            }
            
        }
        if(fast == null)return null;

        while(entry != slow){
            entry = entry.next;
            slow = slow.next;
        }
        return entry;
    }
}
