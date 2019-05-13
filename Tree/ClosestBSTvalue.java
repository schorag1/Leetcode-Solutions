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
    public int closestValue(TreeNode root, double target) {
        int answer = root.val;
        
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - answer))
                answer = root.val;
            
            if(root.val > target)
                root = root.left;
            else
                root = root.right;
        }
        
        return answer;
    }
}