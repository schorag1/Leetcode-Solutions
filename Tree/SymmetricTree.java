/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            
            if(temp1 == null && temp2 == null)
                continue;
            
            if(temp1 == null || temp2 == null)
                return false;
            
            if(temp1.val != temp2.val)
                return false;
            
            queue.add(temp1.left);
            queue.add(temp2.right);
            
            queue.add(temp1.right);
            queue.add(temp2.left);
        }
        
        return true;
    }
}