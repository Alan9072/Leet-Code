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
    public ListNode swapPairs(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return head;

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        ListNode main = head;
        
        ptr2 = head.next;
        ListNode main2 = ptr2;
        while(ptr1 != null && ptr2 !=null){
            ptr1.next = ptr2.next;
            ptr1 = ptr1.next;
            if(ptr1 == null){
                break;
            }else{
                ptr2.next = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        
        ptr1 = main2;
        ptr2 = main;
        ListNode mainHead = main2;
        ListNode curr = ptr1;
        while(curr!=null){
            ptr1 = ptr1.next;
            curr.next = ptr2;
            curr = curr.next;
            if(ptr1 == null){
                break;
            }
            ptr2 = ptr2.next;
            curr.next = ptr1;
            curr = curr.next;
        }
        return mainHead;
    }
}
