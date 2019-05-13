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
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMax(root);
        
        return maxSum;
    }
    
    private int findMax(TreeNode node){
        if(node == null)
            return 0;
        
        int left = Math.max(findMax(node.left), 0);
        int right = Math.max(findMax(node.right), 0);
        
        maxSum = Math.max(maxSum, node.val + left + right);
        
        return Math.max(left, right) + node.val;
    }
}