/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        //making a copy without random pointer;
        Node dummy = new Node(-1);
        Node pointer = dummy;
        Node main = dummy;

        Node ptr = head;
        while(ptr != null){
            Node node = new Node(ptr.val);
            pointer.next = node;
            pointer = pointer.next;
            ptr = ptr.next;
        }
        pointer.next = null;
        main = main.next;
        dummy.next = null;
        /////////////////////////////////////

        Node ptr1 = head;
        Node ptr2 = main;
        Node curr = head;
        while(curr != null){
            ptr1 = ptr1.next;
            curr.next = ptr2;
            curr = curr.next;

            ptr2 = ptr2.next;
            curr.next = ptr1;
            curr = curr.next;
        }

        /////////////////////////////////////

        Node ptr3 = head;
        while(ptr3 != null){
            if(ptr3.random == null){
                ptr3.next.random = null;
            }
            else{
                ptr3.next.random = ptr3.random.next;
            }
            
            ptr3 = ptr3.next.next;
        }

        /////////////////////////////////////

        Node start = head;
        Node dup = head.next;
        Node dupptr = head.next;

        while(start != null){
            start.next = dupptr.next;
            start = start.next;
            if(start == null){
                dupptr.next = null;
            }
            else{
                dupptr.next = start.next;
                dupptr = dupptr.next;
            }
           
        }
        
       return dup; 

    }
}
