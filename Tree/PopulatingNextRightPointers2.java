/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i=0; i<n; i++){
                Node temp = queue.poll();
                
                if(temp.left != null)
                    queue.offer(temp.left);
                
                if(temp.right != null)
                    queue.offer(temp.right);
                
                if(i == n-1)
                    temp.next = null;
                else
                    temp.next = queue.peek();
            }
        }
        
        return root;
    }
}