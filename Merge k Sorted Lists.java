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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode val : lists){
            if(val != null){
                minHeap.add(val);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(minHeap.size() != 0){
            ListNode curr = minHeap.poll();
            if(curr.next != null){
                minHeap.add(curr.next);
            }
            dummy.next = curr;
            dummy = dummy.next;
        }

        dummy.next = null;
        return head.next;
    }
}
