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
        if(root == null){
            sb.append("X").append(",");
            return;
        }
        
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        // String[] temp = data.split(",");
        for(String node: data.split(","))
            nodes.offer(node);
        
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes){
        String value = nodes.poll();
        
        if(value.equals("X"))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));