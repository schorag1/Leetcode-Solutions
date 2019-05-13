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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            root.val = findMin(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }
        
        return root;
    }
    
    private TreeNode findMin(TreeNode node){
        while(node.left != null)
            node = node.left;
        
        return node;
    }
}