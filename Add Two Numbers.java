import java.math.BigInteger; 

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String first = "";
        String second = "";
        ListNode newPointer = new ListNode();

        ListNode pointer = l1;
        while (pointer != null) {
            first += pointer.val;
            pointer = pointer.next;
        }

        pointer = l2;
        while (pointer != null) {
            second += pointer.val;
            pointer = pointer.next;
        }
        //////////////////////////////////////////////////////////////////////////
        StringBuilder reversed1 = new StringBuilder(first);
        reversed1.reverse();
        StringBuilder reversed2 = new StringBuilder(second);
        reversed2.reverse();

        BigInteger num1 = new BigInteger(reversed1.toString());
        BigInteger num2 = new BigInteger(reversed2.toString());
        BigInteger sum = num1.add(num2);
        String total = sum.toString();
        StringBuilder reversedTotal = new StringBuilder(total);
        reversedTotal.reverse();
        String newTotal = reversedTotal.toString();
    

        if (newTotal.length() > first.length() && newTotal.length() > second.length()) {
            ListNode newNode;
            int i = 1;
            if (first.length() > second.length()) {
                newPointer = l1;
                pointer = l1;
            } else {
                newPointer = l2;
                pointer = l2;
            }
            while (pointer != null) {
                pointer.val = Character.getNumericValue(newTotal.charAt(i));
                pointer = pointer.next;
                i++;
            }
            newNode = new ListNode(Character.getNumericValue(newTotal.charAt(0)), newPointer);
            return newNode;
        }
        if (first.length() > second.length()) {
                newPointer = l1;
                pointer = l1;
            } else {
                newPointer = l2;
                pointer = l2;
            }
            int i = 0;
            while (pointer != null) {
                pointer.val = Character.getNumericValue(newTotal.charAt(i));
                pointer = pointer.next;
                i++;
        }
        return newPointer;

    }
}
