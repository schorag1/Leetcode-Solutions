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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(root == null)
            return results;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            LinkedList<Integer> tempList = new LinkedList<>();
            
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                
                if(reverse)
                    tempList.addFirst(current.val);
                else
                    tempList.add(current.val);
                
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            
            results.add(tempList);
            reverse = !reverse;
        }
        
        return results;
    }
}