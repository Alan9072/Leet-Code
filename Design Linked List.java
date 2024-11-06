class MyLinkedList {
    Node head;
    
    public class Node {
        int val;
        Node next;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        int pos = 0;
        Node ptr = head;
        while (ptr != null && pos < index) {
            ptr = ptr.next;
            pos++;
        }
        return (ptr == null) ? -1 : ptr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        int pos = 0;
        Node ptr = head;
        while (ptr != null && pos < index - 1) {
            ptr = ptr.next;
            pos++;
        }
        if (ptr != null) {
            Node newNode = new Node(val);
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        int pos = 0;
        Node ptr = head;
        while (ptr != null && pos < index - 1) {
            ptr = ptr.next;
            pos++;
        }
        if (ptr != null && ptr.next != null) {
            ptr.next = ptr.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
