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
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode pointer = head;
        if(head.next == null)return null;
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        
        int length = 1;
        while(pointer.next!=null){
            length++;
            pointer = pointer.next;
        }
        int pos = length/2;
        pointer = head;
        length = 1;
        while(length!=pos){
            length++;
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return head;

    }
}
