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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
         if (fast != null) {
            slow = slow.next;
        }

        ListNode firstHalf = head;
        ListNode secHalf = reverse(slow);

        while (secHalf != null) {
            if (firstHalf.val != secHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secHalf = secHalf.next;
        }

        return true;
        
    }
    private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode after = null;

    while (curr != null) {
        after = curr.next;  
        curr.next = prev;   
        prev = curr;        
        curr = after;       
    }
    return prev;  
}
}
