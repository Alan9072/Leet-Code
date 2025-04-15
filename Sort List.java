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
///////////////////////////////NOT PREFERD APPROACH////////////////////////////////////////
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)return null;
        List<ListNode> list = new ArrayList<>();
        
        ListNode ptr = head;
        while(ptr != null){
            list.add(ptr);
            ptr = ptr.next;
        }
        Collections.sort(list,(a,b)->a.val - b.val);

        for(int i=1;i<list.size();i++){
            ListNode prev = list.get(i - 1);
            ListNode curr = list.get(i);
            prev.next = curr;
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
