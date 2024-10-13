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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pointer = head;
        while(pointer != null){
            length++;
            pointer = pointer.next;
        }
        if(length == 1 && n==1){
            return null;
        }
        if(length == n){
            return head.next;
        }
        int index = length - n;
        pointer = head;
        int curr = 0;
        ListNode prev = head;
        while(curr < index){
            prev = pointer;
            pointer = pointer.next;
            curr++;
        }
       
        prev.next = pointer.next;
        return head;
    }
}
