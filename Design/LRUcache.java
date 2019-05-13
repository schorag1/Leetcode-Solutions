class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        head = new Node();
        head.prev = null;
        
        tail = new Node();
        tail.next = null;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node temp = map.get(key);
        moveToHead(temp);
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        Node temp = map.get(key);
        
        if(temp != null){
            temp.value = value;
            moveToHead(temp);
            return;
        }
        
        temp = new Node();
        temp.key = key;
        temp.value = value;
        
        map.put(key, temp);
        addNode(temp);
        this.size++;
        
        if(this.size > this.capacity)
            removeLRUentry();
    }
    
    private void removeLRUentry() {
        Node temp = tail.prev;
        removeNode(temp);
        map.remove(temp.key);
        this.size--;
    }
    
    private void addNode(Node temp){
        temp.next = head.next;
        temp.prev = head;
        
        head.next.prev = temp;
        head.next = temp;
    }
    
    private void removeNode(Node temp){
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
    
    private void moveToHead(Node temp){
        removeNode(temp);
        addNode(temp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */