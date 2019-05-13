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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        List<List<Integer>> finalList = new ArrayList<>();
        
        if(root == null)
            return finalList;
        
        while(q.size() != 0){
            int n = q.size();
            
            List<Integer> tempList = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                TreeNode temp = q.remove();
                if(temp == null)
                    continue;
                
                tempList.add(temp.val);
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            
            finalList.add(0, tempList);
        }
        
        return finalList;
    }
}