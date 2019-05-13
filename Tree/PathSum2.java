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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(root, sum, new ArrayList<Integer>(), answer);
        
        return answer;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> answer){
        if(root == null)
            return;
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val)
            answer.add(new ArrayList<Integer>(list));
        
        else{
            dfs(root.left, sum - root.val, list, answer);
            dfs(root.right, sum - root.val, list, answer);
        }
        
        list.remove(list.size()-1);
    }
}