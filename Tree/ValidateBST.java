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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        long lowerbound = Long.MIN_VALUE;
        long upperbound = Long.MAX_VALUE;
        
        return checkBST(root.left, lowerbound, root.val) && checkBST(root.right, root.val, upperbound);
    }
    
    private boolean checkBST(TreeNode root, long lowerbound, long upperbound){
        if(root == null)
            return true;
        
        if((root.val > lowerbound && root.val < upperbound) && checkBST(root.left, lowerbound, root.val) && checkBST(root.right, root.val, upperbound))
            return true;
        
        return false;
    }
}