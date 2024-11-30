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
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode ptr = head;
        ListNode pre = head;
        ListNode strt = head;
        int count = 0;

        while (pre != null) {
            if (count == k) {
                pre.next = null;
                list.add(strt);
                strt = ptr;
                count = 0;
            }
            if(ptr == null)break;// special condition to break
            pre = ptr;
            ptr = ptr.next;
            count++;
            
        }
        // strt now has remaining nodes;
        ListNode dummy = new ListNode();
        ListNode ptr2 = dummy;

        for (int i = 0; i < list.size(); i++) {
            ListNode subhead = reverse(list.get(i));
            ptr2.next = subhead;
            while (ptr2.next != null) {
                ptr2 = ptr2.next;
            }
        }
        ptr2.next = strt;
        return dummy.next;
    }

    public ListNode reverse(ListNode curr) {
        ListNode prev = null;
        ListNode current = curr;
        ListNode after = null;

        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }
}
