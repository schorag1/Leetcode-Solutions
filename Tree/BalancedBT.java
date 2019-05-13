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
    public boolean isBalanced(TreeNode root) {
        if(balancedHeight(root) > -1)
            return true;
        return false;
    }
    
    private int balancedHeight(TreeNode node){
        if(node == null)
            return 0;
        
        int left = balancedHeight(node.left);
        int right = balancedHeight(node.right);
        
        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(left-right) > 1)
            return -1;
        
        if(left > right)
            return left + 1;
        else
            return right + 1;
    }
}