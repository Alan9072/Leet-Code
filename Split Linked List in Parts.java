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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode ptr = head;
        ListNode subptr = head;
        int count = 0;

        while(ptr != null){
            count++;
            ptr = ptr.next;

        }

        int nodePart = count / k;
        int extra = count % k;

        ptr = head;
        int index = 0;
        while(count > 0){
            arr[index] = ptr;
            index++;
            subptr = ptr;

            int start = 1;
            int end = nodePart;
            if(extra > 0){
                end++;
                extra--;
            }

            while(start < end){
                subptr = subptr.next;
                start++;
                count--;
            }
            count--;
            ptr = subptr.next;
            subptr.next = null;
        }
        return arr;
    }
}
