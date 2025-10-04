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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode ptr = head;

        while(ptr != null){

            while(!stk.isEmpty() && stk.peek().val < ptr.val){
                stk.pop();
            }
            stk.push(ptr);
            ptr = ptr.next;
        }

        ListNode dummy = new ListNode();
        ptr = dummy;
        for(ListNode item : stk){
            ptr.next = item;
            ptr = ptr.next;
        }
        ptr.next = null;

        return dummy.next;
    }
}
