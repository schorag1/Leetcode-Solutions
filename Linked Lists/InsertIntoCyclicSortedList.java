/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node temp = new Node(insertVal, null);
            temp.next = temp;
            return temp;
        }
        
        Node temp = head;
        while(temp.val <= temp.next.val && temp.next != head)
            temp = temp.next;
        
        Node max = temp;
        Node dummy = new Node(-1, max.next);
        max.next = null;
        
        temp = dummy;
        while(temp.next != null && temp.next.val < insertVal)
            temp = temp.next;
        temp.next = new Node(insertVal, temp.next);
        
        Node newMax = max.next == null ? max : max.next;
        newMax.next = dummy.next;
        
        return head;
    }
}