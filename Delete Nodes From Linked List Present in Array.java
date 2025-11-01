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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = dummy.next;

        while(next != null){
            if(!set.contains(next.val)){
                prev.next = next;
                prev = next;
            }
            next = next.next;
        }
        prev.next = null;

        return dummy.next;
    }
}
