class LRUCache {

    HashMap<Integer,Node> map;
    int size;
    Node head;
    Node tail;

    class Node{
        Node prev;
        Node next;
        int key;
        int val;

        public Node(Node prev,Node next,int key,int val){
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = new Node(null,null,0,0);
        tail = new Node(null,null,0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node node = map.get(key);
            Node newNode = deleteNode(node);
            insertAtHead(newNode);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            Node newNode = deleteNode(node);
            insertAtHead(newNode);
        }
        else{
            if(map.size() == size){
                Node curr = tail.prev;
                map.remove(curr.key);
                deleteNode(curr);

                Node node = new Node(null,null,key,value);
                map.put(key,node);
                insertAtHead(node);
                
            }
            else{
                Node node = new Node(null,null,key,value);
                map.put(key,node);
                insertAtHead(node);
            }
        }
    }

    public Node deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev  = null;
        return node;
    }
    public void insertAtHead(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
