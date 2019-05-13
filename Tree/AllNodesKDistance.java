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
    public List<Integer> distanceK(TreeNode root, TreeNode startNode, int k) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        populateMap(map, root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(startNode);
        
        int currentLayer = 0;
        
        while(!queue.isEmpty()){
            
            if(currentLayer == k)
                return extractLayerFromQueue(queue);
            
            int n = queue.size();
            
            for(int i=0; i<n; i++){
                TreeNode temp = queue.poll();
                
                if(temp.left != null && !seen.contains(temp.left)){
                    seen.add(temp.left);
                    queue.offer(temp.left);
                }
                
                if(temp.right != null && !seen.contains(temp.right)){
                    seen.add(temp.right);
                    queue.offer(temp.right);
                }
                
                TreeNode parent = map.get(temp);
                if(parent != null && !seen.contains(parent)){
                    seen.add(parent);
                    queue.offer(parent);
                }
            }
            
            currentLayer++;
        }
        
        return new ArrayList<Integer>();
    }
    
    private void populateMap(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent){
        if(root == null)
            return;
        
        map.put(root, parent);
        
        populateMap(map, root.left, root);
        populateMap(map, root.right, root);
    }
    
    private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue){
        List<Integer> results = new ArrayList<>();
        
        for(TreeNode node: queue)
            results.add(node.val);
        
        return results;
    }
}