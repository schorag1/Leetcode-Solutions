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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        
        dfs(root, "", answer);
        
        return answer;
    }
    
    private void dfs(TreeNode root, String temp, List<String> answer){
        if(root == null)
            return;
        
        if(temp.equals(""))
            temp = temp + Integer.toString(root.val);
        else{
            temp += "->";
            temp += Integer.toString(root.val);
        }
        
        if(root.left == null && root.right == null)
            answer.add(temp);
        
        else{
            dfs(root.left, temp, answer);
            dfs(root.right, temp, answer);
        }
    }
}