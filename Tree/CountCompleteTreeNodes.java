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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int heightLeft = 0;
        int heightRight = 0;
        
        TreeNode leftTree = root, rightTree = root;
        
        while(leftTree != null){
            heightLeft++;
            leftTree = leftTree.left;
        }
        
        while(rightTree != null){
            heightRight++;
            rightTree = rightTree.right;
        }
        
        if(heightLeft == heightRight)
            return (int)Math.pow(2,heightLeft)-1;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}