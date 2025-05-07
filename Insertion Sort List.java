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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            list.add(ptr.val);
            ptr = ptr.next;
        }

        //Insertion sort;

        for(int i=1;i<list.size();i++){
            int key = list.get(i);
            int j = i - 1;

            while( j >= 0 && list.get(j) > key){
                list.set(j + 1,list.get(j));
                j = j - 1;
            }
            list.set(j + 1,key);
        }
        ptr = head;
        int k = 0;
        while(ptr != null){
            ptr.val = list.get(k);
            ptr = ptr.next;
            k++;
        }
        return head;
    }
}
