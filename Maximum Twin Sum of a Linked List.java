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
    public int pairSum(ListNode head) {
    ListNode pointer = head;
    int length = 1;
    while(pointer.next!=null){
        length++;
        pointer = pointer.next;
    }
   
    int pos = length/2;
    pointer = head;
    length = 1;
    ListNode pointer2 = head;
    while(length<=pos){
        length++;
        pointer = pointer2;
        pointer2 = pointer2.next;
    }
    pointer.next = null;
    pointer = head;
    // reversing a linked list
    ListNode curr = pointer2;
    ListNode prev = null;
    ListNode next = null;

    while(curr.next!=null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    curr.next = prev;

    pointer2 = curr;
    int sum = 0;
    while(pointer2!=null){
        int newSum = pointer.val + pointer2.val;
        if(newSum > sum )sum = newSum;
        pointer = pointer.next;
        pointer2 = pointer2.next;
    }
    return sum;
    }
}
