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
    public void reorderList(ListNode head) {
  
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode middle = head;
        ListNode pointer = head;
        int length = 1;
        while(pointer.next!=null){
            length++;
            pointer = pointer.next;
        }
        int mid;
        if(length%2==0){
            mid = length/2;
        }
        else{
            mid = length/2 + 1;
        }
        length = 1;
        while(length<mid){
            length++;
            middle = middle.next;
        }
        
        ListNode prev = null;
        ListNode curr = middle.next;
        ListNode after = curr.next;
        middle.next = null;
        while(curr.next!=null){
    
            curr.next = prev;
            prev = curr;
            curr = after;
            after = curr.next;
        }

        curr.next = prev;
        ListNode newCurr = head;
        pointer = curr.next;
        while(newCurr.next!=null){
            
            curr.next = newCurr.next;
            newCurr.next = curr;
            newCurr = curr.next;
            curr = pointer;
            if(pointer!=null){
                 pointer = pointer.next;
            }
           
           
        }
        if(length%2==0){
            newCurr.next = curr;
            
        }
    }
}
