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
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        
        for(int i=0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            
            if(c == ')')
                stack.pop();
            
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')
                    i++;
                
                TreeNode current = new TreeNode(Integer.valueOf(s.substring(j, i+1)));
                
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    
                    if(parent.left == null)
                        parent.left = current;
                    else
                        parent.right = current;
                }
                
                stack.push(current);
            }
        }
        
        return stack.isEmpty() ? null : stack.peek();
    }
}