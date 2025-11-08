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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        if(dfs(head) == 0){
            return dummy.next;
        }else{
            dummy.val = 1;
            return dummy;
        }
    }
    public int dfs(ListNode head){
        if(head == null)return 0;

        int val = head.val * 2 + dfs(head.next);
        int carry = val / 10;
        head.val = val % 10;
        return carry;
    }
}
