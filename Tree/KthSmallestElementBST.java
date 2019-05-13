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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
        while(k != 0){
            TreeNode temp = stack.pop();
            
            k--;
            if(k == 0)
                return temp.val;
            
            TreeNode right = temp.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
        }
        
        return -1;
    }
}