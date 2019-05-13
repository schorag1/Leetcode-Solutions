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
    int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 1;
        depth(root);
        return diameter-1;
    }
    
    public int depth(TreeNode node){
        if(node == null)
            return 0;
        
        int left = depth(node.left);
        int right = depth(node.right);
        
        diameter = Math.max(diameter, left+right+1);
        
        return Math.max(left, right) + 1;
    }
}