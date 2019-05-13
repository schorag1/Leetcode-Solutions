/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i=0; i<n; i++){
                TreeLinkNode temp = queue.poll();
                
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
    }
}