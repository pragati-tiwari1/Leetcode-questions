class LRUCache {
    class Node{
        int key;
        int val;
        Node next = null;
        Node prev = null;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node tail = new Node(0,0);
    Node head = new Node(0,0);
    int c=0;

    public LRUCache(int capacity) {
        c = capacity;
        tail = new Node(0,0);
        head = new Node(0,0); 
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        insert(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
        }
        if(c == map.size()){
            remove(tail.prev);
        }
            insert(new Node(key,value));
            return;
        
    }
    public void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        return;
    }
    public void insert(Node n){
        map.put(n.key,n);
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */