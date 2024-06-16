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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int pos = 0;
        ListNode pointer = head;
        int condition = 0;
        while (pointer != null) {
            pos++;
            if (pos == left) {
                condition = 1;
            }
            if (condition == 1) {
                list.add(pointer.val);
            }
            if (pos == right) {
                condition = 0;
            }

            pointer = pointer.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }

        pointer = head;
        pos = 0;
        int index = 0;
        while (pointer != null) {
            pos++;
            if (pos == left) {
                condition = 1;
            }
            if (condition == 1) {
                pointer.val = list.get(index);
                index++;
            }
            if (pos == right) {
                condition = 0;
            }

            pointer = pointer.next;
        }
        pointer = head;
        return pointer;
    }
}
