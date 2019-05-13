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
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.left = null;
        root.right = prev;
        
        prev = root;
    }

}