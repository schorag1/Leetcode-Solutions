public class MyHashMap {
    private class ListNode{
        int key;
        int value;
        
        ListNode next;
        
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    ListNode[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[1000000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        
        if(nodes[index] == null){
            nodes[index] = new ListNode(-1, -1);
        }
        
        ListNode prev = find(nodes[index], key);
        if(prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        
        if(nodes[index] == null)
            return -1;
        
        ListNode node = find(nodes[index], key);
        
        if(node.next == null)
            return -1;
        else
            return node.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        
        if(nodes[index] == null)
            return;
        
        ListNode prev = find(nodes[index], key);
        if(prev.next == null)
            return;
        
        prev.next = prev.next.next;
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    private ListNode find(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode prev = null;
        
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */