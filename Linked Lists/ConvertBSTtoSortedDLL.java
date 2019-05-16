/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        
        Node dummy = new Node(0, null, null);
        prev = dummy;
        
        inorder(root);
        
        prev.right = dummy.right;
        dummy.right.left = prev;
        
        return dummy.right;
    }
    
    private void inorder(Node current){
        if(current == null)
            return;
        
        inorder(current.left);
        
        prev.right = current;
        current.left = prev;
        prev = current;
        
        inorder(current.right);
    }
}