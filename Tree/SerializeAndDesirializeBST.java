/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        buildString(root, sb);
        
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        
        Queue<String> nodes = new LinkedList<>();
        
        for(String node: data.split(","))
            nodes.offer(node);
        
        return buildTree(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(Queue<String> nodes, int lower, int upper){
        if(nodes.isEmpty())
            return null;
        
        int value = Integer.parseInt(nodes.peek());
        
        if(value < lower || value > upper)
            return null;
        nodes.poll();
        
        TreeNode root = new TreeNode(value);
        root.left = buildTree(nodes, lower, value);
        root.right = buildTree(nodes, value, upper);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));