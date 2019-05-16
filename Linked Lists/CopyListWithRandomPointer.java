/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        
        RandomListNode temp = head;
        
        while(temp != null){
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            RandomListNode randomTemp = map.get(temp);
            
            randomTemp.next = map.get(temp.next);
            randomTemp.random = map.get(temp.random);
            
            temp = temp.next;
        }
        
        return map.get(head);
    }
}