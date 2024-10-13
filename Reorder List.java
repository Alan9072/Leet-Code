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
///////////////////////////////////////////////////////FAST AND SLOW POINTERS////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part2 = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = part2;
        ListNode after = null;
        while (curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        ListNode pointer = head;
        ListNode p1 = head;
        ListNode p2 = prev;
        while (pointer != null) {
            p1 = pointer.next;
            pointer.next = p2;
            pointer = pointer.next;

            if (pointer != null) {
                p2 = pointer.next;
                pointer.next = p1;
                pointer = pointer.next;
            }

        }

    }
}
